package comp671.group.d.librarycheckout.Entity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.UUID;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class CheckedOutBooks extends PanacheEntityBase{
    
    @Id
    @NotNull(message = "books id cannot be null")
    @Column(name = "book_id")
    public UUID bookId;

    @OneToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    public Books book;

    public LocalDate checkoutDate;
    public LocalDate dueDate;


    public static HashMap<String,Object> getDueDate(UUID isbn){
        CheckedOutBooks book = find("book.id", isbn).firstResult();
        HashMap<String,Object> response = new HashMap<>();
        response.put("DueDate", book.dueDate);
        response.put("DaysLeft", ChronoUnit.DAYS.between(LocalDate.now(), book.dueDate));
        response.put("CheckoutDate", book.checkoutDate);
        return response;
    }
}
