package com.example.Wishlist.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Wishlist extends com.example.Wishlist.service.Wishlist {
    @Id
    private String id;

    @NotNull(message = "Wishlist title cannot be null")
    private String title;

    @NotNull(message = "Wishlist rating cannot be null")
    private String rating;

    @NotNull(message = "Wishlist genre cannot be null")
    private String genre;
}
