package com.example.Wishlist.service;

import com.example.Wishlist.exception.WishlistCollectionException;
import com.example.Wishlist.model.Wishlist;
import com.example.Wishlist.repository.WishlistRepository;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WishlistService {

    private final WishlistRepository wishlistRepository;

    public WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public void createWishlist(com.example.Wishlist.service.Wishlist wishlist) throws ConstraintViolationException, WishlistCollectionException {

        Optional<com.example.Wishlist.service.Wishlist> wishlistNameOptional = wishlistRepository.findByTitle(wishlist.getTitle());
        if (wishlistNameOptional.isPresent()) {
            System.out.println();
            throw new WishlistCollectionException(WishlistCollectionException.TitleAlreadyExists());
        } else {
            WishlistRepository.save(wishlist);
        }

    }

    public List<Wishlist> getAllWishlist() {
        List<Wishlist> wishlists = wishlistRepository.findAll();
        if (wishlists.size() > 0) {
            return wishlists;
        } else {
            return new ArrayList<>();
        }
    }

    public void deleteWishlistById(String id) throws WishlistCollectionException {
        Optional<Wishlist> wishlistOptional = wishlistRepository.findById(id);
        if (!wishlistOptional.isPresent()) {
            throw new WishlistCollectionException(WishlistCollectionException.NotFoundException(id));
        } else {
            wishlistRepository.deleteById(id);
        }
    }

    public void updateWishlist(String id, Wishlist newWishlist) throws ConstraintViolationException, WishlistCollectionException {
        Optional<Wishlist> wishlistWithId = wishlistRepository.findById(id);
        Optional<com.example.Wishlist.service.Wishlist> wishlistWithSameTitle = wishlistRepository.findByTitle(newWishlist.getTitle());
        if (wishlistWithId.isPresent()) {
            if (wishlistWithSameTitle.isPresent() && !wishlistWithSameTitle.get().getId().equals(id)) {
                throw new WishlistCollectionException(WishlistCollectionException.TitleAlreadyExists());
            }
            Wishlist wishlistToUpdate = wishlistWithId.get();
            BeanUtils.copyProperties(newWishlist, wishlistToUpdate);

            wishlistToUpdate.setId(id);
            WishlistRepository.save((com.example.Wishlist.service.Wishlist) wishlistToUpdate);
        }else {
            throw new WishlistCollectionException(WishlistCollectionException.NotFoundException(id));
        }
    }
}



