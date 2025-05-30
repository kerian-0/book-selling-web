package org.example.booksellingweb.service;

import org.example.booksellingweb.dao.BookDao;
import org.example.booksellingweb.dao.BookUserDao;
import org.example.booksellingweb.dao.UserDao;
import org.example.booksellingweb.ds.BookUserInfo;
import org.example.booksellingweb.ds.CartItem;
import org.example.booksellingweb.entity.Book;
import org.example.booksellingweb.entity.BookUserOrder;
import org.example.booksellingweb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private BookUserDao bookUserDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private CartItemService cartItemService;

    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }

    public Book getBookById(long id) {
        return bookDao.findById(id).get();
    }

    public List<BookUserInfo> getAllBookUserOrders(String username) {
       return bookUserDao.findByUsername(username);
    }

    public void addBookOrder(String username, Set<CartItem> cartItems) {
        List<Book> books=toBookList(cartItems);
        User user=userDao.findUserByUsername(username).get();
        for (Book book : books) {
            BookUserOrder bookUserOrder=new BookUserOrder();
            bookUserOrder.setDate(LocalDate.now());
            book.addBook(bookUserOrder);
            user.addBookUserOrder(bookUserOrder);
            bookUserDao.save(bookUserOrder);
        }
        cartItemService.removeFromCart();

    }
    private List<Book> toBookList(Set<CartItem> cartItems) {
        return cartItems.stream().map(c->getBookById(c.getId())).toList();
    }
}
