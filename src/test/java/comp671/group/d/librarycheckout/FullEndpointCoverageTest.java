package comp671.group.d.librarycheckout;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.UUID;
import comp671.group.d.librarycheckout.DTOs.FindBook;
import comp671.group.d.librarycheckout.DTOs.BookDTO;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class FullEndpointCoverageTest {


    @Test
    public void testCheckoutBookByTitleSuccess() {
        String title = "Harry Potter and the Philosopher's Stone";
        Response response = given()
            .contentType("application/json")
            .body("{}")
            .when()
            .post("/LibraryAPI/Checkout/book/" + title);
        assertEquals(200, response.getStatusCode());
        System.out.println(response.getBody().asString());
    }

    @Test
    public void testGetDueDate() {
        UUID isbn = UUID.fromString("91a50d7d-ec7d-40f8-908d-add3b08dd5be");
        Response response = given()
            .when()
            .get("/LibraryAPI/Checkout/book/duedate/" + isbn.toString());
        assertEquals(200, response.getStatusCode());
        System.out.println(response.getBody().asString());
    }

    @Test
    public void testFindBookInDb() {
        FindBook fb = new FindBook();
        fb.title = "1984";
        fb.author = "George Orwell";

        Response response = given()
            .contentType("application/json")
            .body(fb)
            .when()
            .post("/LibraryAPI/Checkout/findbook/db");

        assertEquals(200, response.getStatusCode());
        System.out.println(response.getBody().asString());
    }

    @Test
    public void testFindBookOnlineAPI() {
        Response response = given()
            .queryParam("title", "Day by Day Armageddon")
            .queryParam("author", "J. L. Bourne")
            .when()
            .get("/LibraryAPI/Checkout/findbook/online");

        assertEquals(200, response.getStatusCode());
        System.out.println(response.getBody().asString());
    }

    @Test
    public void testAddBook() {
        BookDTO book = new BookDTO();
        book.title = "The Test Book";
        book.author = "Test Author";
        book.publisher = "Test Publisher";
        book.genre = "Test Genre";
        book.summary = "This is a test book.";
        book.pagenumbers = 111;
        book.bookquantity = 1;
        book.publicationdate = LocalDate.of(2020, 1, 1);

        Response response = given()
            .contentType("application/json")
            .body(book)
            .when()
            .post("/LibraryAPI/CRUD/addBook");

        assertEquals(200, response.getStatusCode());
        System.out.println(response.getBody().asString());
    }

    @Test
    public void testGetAllBooks() {
        Response response = given()
            .when()
            .get("/LibraryAPI/CRUD/getAllBooks");

        assertEquals(200, response.getStatusCode());
        System.out.println(response.getBody().asString());
    }
}
