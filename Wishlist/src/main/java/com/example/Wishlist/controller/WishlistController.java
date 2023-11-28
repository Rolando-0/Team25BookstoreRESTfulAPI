package com.example.Wishlist.controller;

import com.example.Wishlist.exception.WishlistCollectionException;
import com.example.Wishlist.service.Wishlist;
import com.example.Wishlist.service.WishlistService;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @RequestMapping(method = RequestMethod.POST, value = "/wishlist")
    public ResponseEntity createWishlist(@RequestBody Wishlist wishlist) {
        try {
            wishlistService.createWishlist(wishlist);
            return new ResponseEntity("Successfully added wishlist" + wishlist.getTitle(), HttpStatus.OK);
        }
        catch (ConstraintViolationException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        catch (WishlistCollectionException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/wishlist")
    public ResponseEntity getAllWishlist() {
        List<com.example.Wishlist.model.Wishlist> wishlists = wishlistService.getAllWishlist();
        return new ResponseEntity(wishlists, wishlists.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}
