package comp671.group.d.librarycheckout;

import comp671.group.d.librarycheckout.Entity.Books;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class BooksTest {

    // @BeforeEach
    // @Transactional
    // public void setup() {
    //     Books.deleteAll();

    //     Books b = new Books();
    //     b.id = UUID.randomUUID();
    //     b.author = "Test Author";
    //     b.title = "Test Title";
    //     b.genre = "Test Genre";
    //     b.publisher = "Test Publisher";
    //     b.summary = "Some summary";
    //     b.pagenumbers = 123;
    //     b.publicationdate = LocalDate.now();
    //     b.bookquantity = 3;
    //     b.booksisbn = List.of();
    //     b.persist();
    // }

    @Test
    @Transactional
    public void testFindAllBooksPopulatesISBNsCorrectly() {
        List<Books> result = Books.findAllBooks();
        assertEquals(25, result.size());

        Books b = result.get(0);
        assertEquals(15, b.booksisbn.size());
        assertNotNull(b.booksisbn.get(0));
    }
    @Test
    public void testGetAllBooksEndpoint() {
        given()
            .when().get("/LibraryAPI/CRUD/getAllBooks")
            .then()
            .statusCode(200)
            .body("size()", greaterThan(0));
    }
}

