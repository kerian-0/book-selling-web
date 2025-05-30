package org.example.booksellingweb.ds;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartItem {
    private Long id;
    private String imageUrl;
    private String bookName;
    private double price;


    public CartItem(Long id,  String bookName, double price,String imageUrl) {
        this.id = id;
        this.bookName = bookName;
        this.imageUrl = imageUrl;
        this.price = price;
    }
}
