package comp671.group.d.librarycheckout.Resources;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import comp671.group.d.librarycheckout.DTOs.BookDTO;
import comp671.group.d.librarycheckout.Entity.Books;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Tag(name = "Library Checkout CRUD API", description = "CRUD Operations of Library Checkout CRUD API")
@Path("/libraryAPI/CRUD")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookControllerResource {
    
    @Path("/getAllBooks")
    @Tag(ref = "Library Checkout CRUD API", description = "Gets All Books")
    @GET
    @Transactional(TxType.SUPPORTS)
    public Response getAllBooks(){
        return Response.ok(Books.findAllBooks()).build();
    }

    @Path("/findBooksByAuthor/{author}")
    @GET
    @Tag(ref =  "Library Checkout CRUD API", description = "Find a Book By Author Name")
    @Transactional(TxType.SUPPORTS)
    public Response getBookByAuthor(@PathParam("author") String author){
        return Response.ok(Books.getBooksByAuthor(author)).build();
    }

    @Path("/addBook")
    @POST
    @Tag(ref =  "Library Checkout CRUD API", description = "Add a Book to DB")
    @Transactional(TxType.REQUIRED)
    public Response addBook(BookDTO book){
        Books addBook = new Books();
        book.generateISBN();
        addBook.author = book.author;
        addBook.bookquantity = book.bookquantity;
        addBook.booksisbn = book.booksisbn;
        addBook.genre = book.genre;
        addBook.pagenumbers = book.pagenumbers;
        addBook.publicationdate = book.publicationdate;
        addBook.publisher = book.publisher;
        addBook.summary = book.summary;
        addBook.title = book.title;
        return Response.ok(Books.addBook(addBook)).build();
    }
}
