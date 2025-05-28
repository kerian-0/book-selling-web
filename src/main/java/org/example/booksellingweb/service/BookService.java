package org.example.booksellingweb.service;

import org.example.booksellingweb.dao.BookUserDao;
import org.example.booksellingweb.ds.BookUserInfo;
import org.example.booksellingweb.entity.Book;
import org.example.booksellingweb.entity.BookUserOrder;
import org.example.booksellingweb.repostory.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookUserDao bookUserOrder;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).get();
    }

    public List<BookUserInfo> getAllBookUserOrders(String username) {
       return bookUserOrder.findByUsername(username);
    }
}
