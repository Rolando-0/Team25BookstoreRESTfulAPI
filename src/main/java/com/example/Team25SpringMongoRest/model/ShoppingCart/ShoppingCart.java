package com.example.Team25SpringMongoRest.model.ShoppingCart;

import com.example.Team25SpringMongoRest.model.BookDetails.Book;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "shoppingCarts")
public class ShoppingCart {

    @Id
    private String userId;
    private List<Book> books;
}