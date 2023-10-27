package com.example.Team25SpringMongoRest.model.ShoppingCart;

import lombok.Data;
import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotNull;

@Data
public class Book {

    @Id
    private String id;

    @NotNull
    private String name;

    @NotNull
    private double price;
}