package com.example.Wishlist.exception;

public class WishlistCollectionException extends Exception {

    public WishlistCollectionException(String message) {
        super(message);
    }


    public static String NotFoundException(String id) {
        return "wishlist with " + id + "not found";
    }

    public static String TitleAlreadyExists() {
        return "wishlist with given title already exists!";
    }
}
