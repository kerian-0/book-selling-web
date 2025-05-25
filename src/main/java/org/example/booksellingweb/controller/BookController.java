package org.example.booksellingweb.controller;

import org.example.booksellingweb.ds.CartItem;
import org.example.booksellingweb.service.BookService;
import org.example.booksellingweb.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Controller
@RequestMapping("/library")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CartItemService cartItemService;

    @GetMapping("/add-to-cart")
    public String addToCart(@RequestParam("id")Long id) {
        cartItemService.addtoCart(bookService.getBookById(id));
        return "redirect:/library/book-details?id="+id;
    }
    @GetMapping("view-cart")
    public String cartView(Model model) {
        model.addAttribute("cartItems", cartItemService.getCartItems());
        return "cart-view";
    }

    @ModelAttribute("totalPrice")
    public double totalPrice() {
       return cartItemService.getCartItems().stream().map(c->c.getPrice()).mapToDouble(Double::doubleValue).sum();

    }

    @GetMapping("/books")
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "book-ui";
    }
    @GetMapping("/book-details")
    public String getFindBookId(@RequestParam("id")Long id, Model model){
        model.addAttribute("bookDetails", bookService.getBookById(id));
        return "book-details";
    }
    @ModelAttribute("cartItem")
    public Set<CartItem> getCartItems() {
        return cartItemService.getCartItems();
    }
}
