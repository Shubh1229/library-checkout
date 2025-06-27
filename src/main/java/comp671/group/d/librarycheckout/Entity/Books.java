package comp671.group.d.librarycheckout.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.jboss.logging.Logger;

import comp671.group.d.librarycheckout.DTOs.FindBook;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import jakarta.ws.rs.QueryParam;

@Entity
public class Books extends PanacheEntityBase{
    @Id
    @NotNull(message = "ID cannot be null")
    public UUID id = UUID.randomUUID();

    @NotNull(message = "page numbers cannot be null")
    @Min(value = 1, message = "book copies must be above 0")
    public int bookquantity;

    public List<UUID> booksisbn = generateISBN();

    public List<UUID> checkedoutbooks = new ArrayList<>();

    @NotBlank(message = "author cannot be blank")
    @NotEmpty(message = "author cannot be empty")
    public String author;

    @NotBlank(message = "title cannot be blank")
    @NotEmpty(message = "title cannot be empty")
    public String title;

    @NotBlank(message = "genre cannot be blank")
    @NotEmpty(message = "genre cannot be empty")
    public String genre;

    @NotBlank(message = "publisher cannot be blank")
    @NotEmpty(message = "publisher cannot be empty")
    public String publisher;

    public String summary;

    @NotNull(message = "page numbers cannot be null")
    @Min(value = 10, message = "page numbers must be above 9")
    public int pagenumbers;

    @NotNull(message = "publication date cannot be null")
    public LocalDate publicationdate;

    private List<UUID> generateISBN() {
        List<UUID> list = new ArrayList<>();
        for(int i = 0; i < (( bookquantity > 0) ? bookquantity : 1); i++) {
            list.add(UUID.randomUUID());
        }
        return list;
    }


    private static final Logger log = Logger.getLogger(Books.class);

    public static boolean addBook(@Valid Books book){

        try {
            log.info("Book " + book.id.toString() +  " is being added to DB");
            book.persist();
            return true;
        } catch (Exception e) {
            log.info("Could not persist Book into DB:\n" + e.getMessage());
            return false;
        }
    }

    public static List<Books> getBooksByAuthor(String author){
        return find("author", author).list();
    }

    public static List<Books> getSpecificBook( FindBook book) throws Exception {
        if (book == null) throw new Exception("All queries to find book are null");

        boolean hasAuthor = book.author != null && !book.author.isBlank() && !book.author.isEmpty();
        boolean hasTitle = book.title != null && !book.title.isBlank() && !book.title.isEmpty();
        boolean hasGenre = book.genre != null && !book.genre.isBlank() && !book.genre.isEmpty();

        if (!hasAuthor && !hasTitle && !hasGenre) {
            throw new Exception("At least one field (author, title, or genre) must be provided.");
        }

        if (hasAuthor && !hasTitle && !hasGenre) {
            return find("author", book.author).list();
        }

        if (!hasAuthor && hasTitle && !hasGenre) {
            return find("title", book.title).list();
        }

        if (!hasAuthor && !hasTitle && hasGenre) {
            return find("genre", book.genre).list();
        }

        if (hasAuthor && hasTitle && !hasGenre) {
            return find("author = ?1 and title = ?2", book.author, book.title).list();
        }

        if (hasAuthor && !hasTitle && hasGenre) {
            return find("author = ?1 and genre = ?2", book.author, book.genre).list();
        }

        if (!hasAuthor && hasTitle && hasGenre) {
            return find("title = ?1 and genre = ?2", book.title, book.genre).list();
        }

        // All three fields provided
        return find("author = ?1 and title = ?2 and genre = ?3", book.author, book.title, book.genre).list();
    }

    public static List<Books> findAllBooks(){
        var allbooks = Books.<Books>listAll();
        for (Books b : allbooks) {
            if(b.booksisbn == null || b.booksisbn.size() != b.bookquantity){
                List<UUID> list = new ArrayList<>();
                for(int i = 0; i < b.bookquantity; i++){
                    list.add(UUID.randomUUID());
                }
                b.booksisbn = list;
                b.persist();
            }
        }
        return allbooks;
    }

    public static Books findBookByTitle(String title){
        return find("title", title).firstResult();
    }


}
