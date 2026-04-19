package Wishlist.com.project.controller;

import Wishlist.com.project.model.User;
import Wishlist.com.project.model.Wish;
import Wishlist.com.project.model.WishList;
import Wishlist.com.project.repository.WishlistRepository;
import Wishlist.com.project.service.WishlistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//rest så spring forstår at den skal spytte det ud som json format, efter kan det ændres til Controller nå vi implementere html og css.
@Controller
@RequestMapping("/wish")
public class WishlistController {

    private final WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @GetMapping("")
    public String showFrontPage() {
        return "index";
    }

    @GetMapping("/opret")
    public String showSignupPage() {
        return "opret";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/signup")
    public String signupUser(@ModelAttribute User user) {
        wishlistService.signupUser(user);
        return "redirect:/wish/login";
    }

    @PostMapping("/login")
    public String findUserForLogin(@ModelAttribute User user, Model model) {

        List<User> users = wishlistService.findUserForLogin(user.getEmail(), user.getPassword());

        if (users.isEmpty()) {
            model.addAttribute("error", "Forkert email eller password");
            return "login";
        }

        return "redirect:/wish";
    }

}