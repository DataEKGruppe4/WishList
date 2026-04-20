package Wishlist.com.project.service;

import Wishlist.com.project.model.User;
import Wishlist.com.project.model.Wish;
import Wishlist.com.project.model.WishList;
import Wishlist.com.project.repository.WishListRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListService {

    private final WishListRepository wishListRepository;

    public WishListService(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    public void signupUser(User user) {
        wishListRepository.signupUser(user);
    }

    public void createWish(Wish wish, int wishListId) {
        wishListRepository.createWish(wish, wishListId);
    }

    public void markWishAsBought(int wishId, boolean bought) {
        wishListRepository.markWishAsBought(wishId, bought);
    }

    public List<User> findUserForLogin(String email, String password) {
        return wishListRepository.findUserForLogin(email, password);
    }

    public User findUserById(int userId) {
        return wishListRepository.findUserById(userId);
    }

    public List<WishList> findWishListsByUserId(int userId) {
        return wishListRepository.findWishListsByUserId(userId);
    }

    public WishList findWishListById(int wishList) {
        return wishListRepository.findWishListById(wishList);
    }

    public List<Wish> findWishesByWishListId(int wishId) {
        return wishListRepository.findWishesByWishListId(wishId);
    }


}
