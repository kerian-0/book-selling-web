package org.example.booksellingweb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String genre;
    private String description;
    private LocalDate releaseDate;
    private String imageUrl;
    private double price;
    @OneToMany(mappedBy = "book",cascade = CascadeType.PERSIST)
    private List<BookUserOrder> bookUserOrders=new ArrayList<>();

    public void addBook(BookUserOrder order) {
        order.setBook(this);
        bookUserOrders.add(order);
    }

    public Book(String title, String author, String genre, String description, LocalDate releaseDate, String imageUrl,double price) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.description = description;
        this.releaseDate = releaseDate;
        this.imageUrl = imageUrl;
        this.price = price;
    }
}
