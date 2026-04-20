package Wishlist.com.project.controller;

import Wishlist.com.project.model.User;
import Wishlist.com.project.model.Wish;
import Wishlist.com.project.model.WishList;
import Wishlist.com.project.repository.WishListRepository;
import Wishlist.com.project.service.WishListService;
import Wishlist.com.project.service.WishListService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//rest så spring forstår at den skal spytte det ud som json format, efter kan det ændres til Controller nå vi implementere html og css.
@Controller
@RequestMapping("/wish")
public class WishListController {

    private final WishListService wishListService;

    public WishListController(WishListService wishListService) {
        this.wishListService = wishListService;
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
        wishListService.signupUser(user);
        return "redirect:/wish/login";
    }

    @PostMapping("/login")
    public String findUserForLogin(@ModelAttribute User user, HttpSession session, Model model) {

        List<User> users = wishListService.findUserForLogin(user.getEmail(), user.getPassword());

        if (!users.isEmpty()) {
            User loggedInUser = users.get(0);
            session.setAttribute("userId", loggedInUser.getUserId());
            return "redirect:/wish/dashboard";
        }

        model.addAttribute("error", "Forkert email eller password");
        return "login";
    }

    @PostMapping("/wishlist/{id}/create-wish")
    public String createWish(@PathVariable int id, @ModelAttribute Wish wish, HttpSession session) {

        Integer userId = (Integer) session.getAttribute("userId");

        if (userId == null) {
            return "redirect:/wish/login";
        }

        WishList wishList = wishListService.findWishListById(id);

        if (wishList.getUserId() != userId) {
            return "redirect:/wish/dashboard";
        }

        wishListService.createWish(wish, id);

        return "redirect:/wish/wishlist/" + id;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/wish/login?logout";

    }

    @GetMapping("/dashboard")
    public String showDashboard(HttpSession session, Model model) {
        Integer userId = (Integer) session.getAttribute("userId");

        if (userId == null) {
            return "redirect:/wish/login";
        }

        User user = wishListService.findUserById(userId);
        List<WishList> wishLists = wishListService.findWishListsByUserId(userId);


        model.addAttribute("user", user);
        model.addAttribute("wishLists", wishLists);

        return "dashboard";
    }

    @GetMapping("/wishlist/{id}")
    public String showWishList(@PathVariable int id, HttpSession session, Model model) {

        Integer userId = (Integer) session.getAttribute("userId");

        if (userId == null) {
            return "redirect:/wish/login";
        }

        User user = wishListService.findUserById(userId);
        WishList wishList = wishListService.findWishListById(id);
        List<Wish> wishes = wishListService.findWishesByWishListId(id);

        if (wishList.getUserId() != userId) {
            return "redirect:/wish/dashboard";
        }

        model.addAttribute("user", user);
        model.addAttribute("wishList", wishList);
        model.addAttribute("wishes", wishes);

        return "wishList";
    }

    @PostMapping("/wishlist/{wishlistId}/wish/{wishId}/bought")
    public String markWishAsBought(@PathVariable int wishlistId,
                                   @PathVariable int wishId,
                                   HttpSession session) {

        Integer userId = (Integer) session.getAttribute("userId");

        if (userId == null) {
            return "redirect:/wish/login";
        }

        WishList wishList = wishListService.findWishListById(wishlistId);

        if (wishList.getUserId() != userId) {
            return "redirect:/wish/dashboard";
        }

        wishListService.markWishAsBought(wishId, true);

        return "redirect:/wish/wishlist/" + wishlistId;
    }

    @PostMapping("/wishlist/{wishlistId}/wish/{wishId}/unbought")
    public String markWishAsUnbought(@PathVariable("wishlistId") int wishListId,
                                     @PathVariable("wishId") int wishId,
                                     HttpSession session) {

        Integer userId = (Integer) session.getAttribute("userId");

        if (userId == null) {
            return "redirect:/wish/login";
        }

        WishList wishList = wishListService.findWishListById(wishListId);

        if (wishList.getUserId() != userId) {
            return "redirect:/wish/dashboard";
        }

        wishListService.markWishAsBought(wishId, false);

        return "redirect:/wish/wishlist/" + wishListId;
    }


}