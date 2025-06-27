package comp671.group.d.librarycheckout.DTOs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookDTO {
    public List<UUID> booksisbn = new ArrayList<>();
    public int bookquantity;
    public String title;
    public String author;
    public String genre;
    public String publisher;
    public String summary;
    public int pagenumbers;
    public LocalDate publicationdate;

    public void generateISBN(){
        for(int i = 0; i < bookquantity; i++){
            this.booksisbn.add(UUID.randomUUID());
        }
    }
}
