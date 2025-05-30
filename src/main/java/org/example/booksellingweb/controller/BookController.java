package org.example.booksellingweb.controller;

import lombok.RequiredArgsConstructor;
import org.example.booksellingweb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

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

    @GetMapping("/book/details")
    public String bookDetails(@RequestParam("id")long id, Model model){
        model.addAttribute("book",bookService.getBookById(id));
        return "bookDetails";
    }
}
