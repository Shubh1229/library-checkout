package comp671.group.d.librarycheckout.Resources;

import java.net.URI;
import java.net.http.HttpClient;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;
import org.json.JSONObject;

import comp671.group.d.librarycheckout.DTOs.FindBook;
import comp671.group.d.librarycheckout.Entity.Books;
import comp671.group.d.librarycheckout.Entity.CheckedOutBooks;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;


@Path("/LibraryAPI/Checkout")
@Tag(name = "Library Checkout API",description = "Perform different requests on Library Checkout API")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CheckoutControllerResource {
    
    private static final Logger log = Logger.getLogger(CheckoutControllerResource.class);

    @POST
    @Transactional(TxType.REQUIRED)
    @Path("/book/{title}")
    @Tag(ref = "Library Checkout API", description = "Checkout a Book Using Title")
    public Response checkoutBookByTitle(@PathParam("title") String title){
        log.info("Book title: " + title + " searched for....");
        var book = Books.findBookByTitle(title);
        log.info("Book found:\n\t" + book.toString());
        UUID isbn = null;
        if(book.checkedoutbooks == null || book.checkedoutbooks.isEmpty()) book.checkedoutbooks = new ArrayList<>();
        for (var b : book.booksisbn) {
            if(book.checkedoutbooks.contains(b)){
                continue;
            }
            isbn = b;
            break;
        }
        if(isbn == null) return Response.status(400, "No Available Books To Checkout...").build();
        book.checkedoutbooks.add(isbn);
        book.persist();
        LocalDate now = LocalDate.now();
        var due = now.plusDays(7);
        CheckedOutBooks chb = new CheckedOutBooks();
        chb.bookid = isbn;
        chb.refid = book.id;
        chb.dueDate = due;
        chb.checkoutDate = now;
        chb.persist();
        return Response.ok(chb).build();
    }

    @GET
    @Transactional(TxType.SUPPORTS)
    @Path("/book/duedate/{isbn}")
    @Tag(ref = "Library Checkout API", description = "See Time Left Until Due Date")
    public Response getDueDate(@PathParam("isbn") String isbn){
        UUID id = UUID.fromString(isbn);
        var book = CheckedOutBooks.getDueDate(id);
        return Response.ok(book).build();
    }

    @POST
    @Transactional(TxType.REQUIRED)
    @Path("/findbook/db")
    @Tag(ref = "Library Checkout API", description = "Find a Book From DB")
    public Response findBook(FindBook book) {
        try {
            var b = Books.getSpecificBook(book);
            if (b != null && !b.isEmpty()) {
                return Response.ok(b).build();
            }
            // Redirect to online search
            URI redirection = UriBuilder.fromPath("/LibraryAPI/Checkout/findbook/online")
                    .queryParam("title", book.title)
                    .queryParam("author", book.author)
                    .build();
            return Response.seeOther(redirection).build(); // 303 Redirect
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(400, "Could not find book with given parameters...").build();
    }

    @GET
    @Transactional(TxType.SUPPORTS)
    @Path("/findbook/online")
    @Tag(ref = "Library Checkout API", description = "Find Book From Open Library")
    public Response findBookOnlineAPI(@QueryParam("title") String title, @QueryParam("author") String author) {
        try {
            log.info("Starting OpenLibrary API search...");

            HttpClient client = HttpClient.newHttpClient();
            String base = "https://openlibrary.org/search.json?limit=10";

            if (title != null && !title.isBlank()) {
                base += "&title=" + java.net.URLEncoder.encode(title, java.nio.charset.StandardCharsets.UTF_8);
                log.info("Added title to query: " + title);
            }

            if (author != null && !author.isBlank()) {
                base += "&author=" + java.net.URLEncoder.encode(author, java.nio.charset.StandardCharsets.UTF_8);
                log.info("Added author to query: " + author);
            }

            log.info("Final API URL: " + base);

            var request = java.net.http.HttpRequest.newBuilder()
                    .uri(new URI(base))
                    .header("Accept", "application/json")
                    .GET()
                    .build();

            var response = client.send(request, java.net.http.HttpResponse.BodyHandlers.ofString());

            log.info("Received response with status code: " + response.statusCode());

            // Parse JSON manually using org.json
            JSONObject obj = new JSONObject(response.body());
            var docs = obj.getJSONArray("docs");
            log.info("Number of books found: " + docs.length());

            List<OnlineBookDTO> results = new ArrayList<>();

            for (int i = 0; i < docs.length(); i++) {
                var d = docs.getJSONObject(i);
                String bookTitle = d.optString("title", null);
                String bookAuthor = d.has("author_name") ? d.getJSONArray("author_name").optString(0, null) : null;
                Integer publishYear = d.has("first_publish_year") ? d.getInt("first_publish_year") : null;
                String key = d.optString("key", null);

                log.info(String.format("Parsed Book %d: Title='%s', Author='%s', Year=%s, Key='%s'", 
                            i + 1, bookTitle, bookAuthor,
                            publishYear != null ? publishYear.toString() : "null",
                            key));

                OnlineBookDTO dto = new OnlineBookDTO(bookTitle, bookAuthor, publishYear, key);
                results.add(dto);
            }

            log.info("Returning " + results.size() + " book(s) to client.");
            return Response.ok(results).build();

        } catch (Exception e) {
            log.info("Failed to retrieve or parse OpenLibrary API response: " + e.getMessage());
            e.printStackTrace();
            return Response.status(500, "Could not search Open Library API.").build();
        }
    }




    public static class OnlineBookDTO {
        public String title;
        public String author;
        public Integer firstPublishYear;
        public String openLibraryWorkKey;
        public boolean isAvailableInLibrary = false;
        public String source = "OpenLibrary";

        public OnlineBookDTO(String title, String author, Integer firstPublishYear, String key) {
            this.title = title;
            this.author = author;
            this.firstPublishYear = firstPublishYear;
            this.openLibraryWorkKey = key;
        }
    }

}


