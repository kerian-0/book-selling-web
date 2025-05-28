package org.example.booksellingweb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

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

    public Book(String title, String author, String genre, String description, LocalDate releaseDate, String imageUrl) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.description = description;
        this.releaseDate = releaseDate;
        this.imageUrl = imageUrl;
    }
}
