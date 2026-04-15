package Wishlist.com.project.controller;

import Wishlist.com.project.model.Wish;
import Wishlist.com.project.repository.Wishlistrepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class WishlistController {
    Wishlistrepo wishlistrepo;

    WishlistController(Wishlistrepo wishlistrepo) {
        this.wishlistrepo = wishlistrepo;

    }

    @GetMapping("/wish")
    public List<Wish> testWish() {
        return wishlistrepo.findAll();
    }
}
