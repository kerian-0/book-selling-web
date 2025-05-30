package org.example.booksellingweb.controller;

import org.example.booksellingweb.ds.BookUserInfo;
import org.example.booksellingweb.ds.CartItem;
import org.example.booksellingweb.service.BookService;
import org.example.booksellingweb.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;
import java.util.Set;
@Controller
public class CartItemController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CartItemService cartItemService;

//


    @GetMapping("view-cart")
    public String cartView(Model model) {
        model.addAttribute("cartItems", cartItemService.getCartItems());
        return "cart-view";
    }
    @ModelAttribute("totalPrice")
    public double totalPrice() {
        return cartItemService.getCartItems().stream().map(
                c -> c.getPrice()).mapToDouble(Double::doubleValue).sum();
    }
    @GetMapping("/order-history")
    public String orderHistory(Principal principal, Model model) {
        model.addAttribute("orderItems",bookService.getAllBookUserOrders(principal.getName()));
        return "book-history";
    }

    @GetMapping("/order-success")
    public String proceed(Principal principal){
        bookService.addBookOrder(principal.getName(),cartItemService.getCartItems());
        return "order-success";

    }


}
