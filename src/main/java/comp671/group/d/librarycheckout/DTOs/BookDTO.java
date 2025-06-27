package comp671.group.d.librarycheckout.DTOs;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class BookDTO {
    public List<UUID> booksisbn;
    public int bookquantity;
    public String title;
    public String author;
    public String genre;
    public String publisher;
    public String summary;
    public int pagenumbers;
    public LocalDate publicationdate;
}
