package com.example.Wishlist.repository;

import com.example.Wishlist.model.Wishlist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface WishlistRepository extends MongoRepository<Wishlist, String> {


    static void save(com.example.Wishlist.service.Wishlist wishlist) {
    }

    @Query("{'title':?0}")
    Optional<com.example.Wishlist.service.Wishlist> findByTitle(String title);
}
