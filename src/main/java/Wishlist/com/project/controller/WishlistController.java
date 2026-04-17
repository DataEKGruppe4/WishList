package Wishlist.com.project.controller;

import Wishlist.com.project.model.User;
import Wishlist.com.project.model.Wish;
import Wishlist.com.project.model.WishList;
import Wishlist.com.project.repository.WishlistRepository;
import Wishlist.com.project.service.WishlistService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//rest så spring forstår at den skal spytte det ud som json format, efter kan det ændres til Controller nå vi implementere html og css.
@RestController
@RequestMapping("/wish")
public class WishlistController {

    //private final WishlistRepository wishlistRepository;

    private final WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    //Her henter vi data fra service som henter data fra repository, hvor vi kan se alle wishes
    @GetMapping
    public List<Wish> getAllWishes() {
        return wishlistService.getAllWishes();
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return wishlistService.getAllUsers();
    }

    @GetMapping("/wishlists")
    public List<WishList> getAllWishLists(){
        return wishlistService.getAllWishLists();
    }
}