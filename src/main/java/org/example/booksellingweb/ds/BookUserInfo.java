package org.example.booksellingweb.ds;

import java.time.LocalDate;

public class BookUserInfo {
    private Long id;
    private String bookName;
    private String username;
    private LocalDate date;

    public BookUserInfo(Long id, String bookName, String username, LocalDate date) {
        this.id = id;
        this.bookName = bookName;
        this.username = username;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public String getUsername() {
        return username;
    }

    public LocalDate getDate() {
        return date;
    }
}
