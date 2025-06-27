package comp671.group.d.librarycheckout;

import comp671.group.d.librarycheckout.Entity.Books;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class BooksTest {

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
    @Test
    public void testGetBooksByAuthor(){
        Response response = given()
            .contentType("application/json")
            .body("{}")
            .when().get("/LibraryAPI/CRUD/findBooksByAuthor/The Hobbit");
        assertEquals(200, response.statusCode());
        String body = response.body().asString();
        assertNotNull(body);
        System.out.println(body);
    }
}