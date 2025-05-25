package org.example.booksellingweb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public Book(String bookName, String authorName, String description, String imageUrl, double price) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
    }
}
