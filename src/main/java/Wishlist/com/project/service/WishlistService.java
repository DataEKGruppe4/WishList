package Wishlist.com.project.service;

import Wishlist.com.project.model.User;
import Wishlist.com.project.model.Wish;
import Wishlist.com.project.model.WishList;
import Wishlist.com.project.repository.WishlistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    private final WishlistRepository wishlistRepository;

    public WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public List<Wish> getAllWishes() {
        return wishlistRepository.getAllWishes();
    }

    public List<User> getAllUsers(){
        return wishlistRepository.getAllUsers();
    }

    public List<WishList> getAllWishLists(){
        return wishlistRepository.getAllWishLists();
    }

    public void signupUser(User user){
        wishlistRepository.signupUser(user);
    }

}
