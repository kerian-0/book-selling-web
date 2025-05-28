package org.example.booksellingweb.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookName;
    private String authorName;
    private String description;
    private String imageUrl;
    private double price;
@OneToMany(mappedBy = "book")
    private List<BookUserOrder> bookUserOrders=new ArrayList<>();

public void addBookUserOrder(BookUserOrder bookUserOrder) {
    bookUserOrder.setBook(this);
    bookUserOrders.add(bookUserOrder);

}

    public Book(String bookName, String authorName, String description, String imageUrl, double price) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
    }
}
