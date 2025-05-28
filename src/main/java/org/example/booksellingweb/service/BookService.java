package org.example.booksellingweb.service;

import org.example.booksellingweb.dao.BookDao;
import org.example.booksellingweb.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }

    public Book getBookById(long id) {
        return bookDao.findById(id).get();
    }
}
