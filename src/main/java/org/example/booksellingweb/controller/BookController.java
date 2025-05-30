package org.example.booksellingweb.controller;

import lombok.RequiredArgsConstructor;
import org.example.booksellingweb.ds.CartItem;
import org.example.booksellingweb.service.BookService;
import org.example.booksellingweb.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CartItemService cartItemService;

    @GetMapping("/")
    public String init(){
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("books",bookService.getAllBooks());
        return "home";
    }

    @GetMapping("/gallery")
    public String gallery(Model model){
        model.addAttribute("books",bookService.getAllBooks());
        return "gallery";
    }

    @GetMapping("/add-to-cart")
    public String addToCart(@RequestParam("id")Long id) {
        cartItemService.addtoCart(bookService.getBookById(id));
        return "redirect:/book/details?id="+id;
    }

    @GetMapping("/book/details")
    public String bookDetails(@RequestParam("id")long id, Model model){
        model.addAttribute("book",bookService.getBookById(id));
        return "book-details";
    }

    @ModelAttribute("cartItem")
    public Set<CartItem> getCartItems() {
        return cartItemService.getCartItems();
    }
}
