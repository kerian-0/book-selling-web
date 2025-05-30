package org.example.booksellingweb.service;

import org.example.booksellingweb.ds.BookUserInfo;
import org.example.booksellingweb.ds.CartItem;
import org.example.booksellingweb.entity.Book;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CartItemService {

    private Set<CartItem> cartItems = new HashSet<>();

    public void addtoCart(Book book) {
            cartItems.add(toCartItem(book));
    }
    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public void removeFromCart(){
        cartItems.clear();
    }

    private CartItem toCartItem(Book book) {
        return new CartItem(book.getId(),book.getAuthor(),book.getPrice(),book.getImageUrl());
    }


}
