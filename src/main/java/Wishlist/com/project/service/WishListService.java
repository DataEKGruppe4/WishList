package Wishlist.com.project.service;

import Wishlist.com.project.exception.DuplicateUserException;
import Wishlist.com.project.exception.InvalidLoginException;
import Wishlist.com.project.model.User;
import Wishlist.com.project.model.Wish;
import Wishlist.com.project.model.WishList;
import Wishlist.com.project.repository.WishListRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListService {

    private final WishListRepository wishListRepository;

    public WishListService(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    public void signupUser(User user) {
        try {
            wishListRepository.signupUser(user);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateUserException("Denne email findes allerede.");
        }
    }

    public User findUserForLogin(String email, String password) {

        List<User> users = wishListRepository.findUserForLogin(email, password);

        if (users.isEmpty()) {
            throw new InvalidLoginException("Forkert email eller password");
        }

        return users.getFirst();
    }

    public void createWish(Wish wish, int wishListId) {
        wishListRepository.createWish(wish, wishListId);
    }

    public void createWishList(WishList wishList, int userId) {
        wishListRepository.createWishList(wishList, userId);
    }

    public void markWishAsBought(int wishId, boolean bought) {
        wishListRepository.markWishAsBought(wishId, bought);
    }

    public void deleteWish(int wishId) {
        wishListRepository.deleteWish(wishId);
    }

    public void deleteWishList(int wishListId) {
        wishListRepository.deleteWishList(wishListId);
    }

    public void deleteWishListWithWishes(int wishListId) {
        wishListRepository.deleteWishesByWishListId(wishListId);
        wishListRepository.deleteWishList(wishListId);
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

    public void updateWishList(WishList wishList) {
        wishListRepository.updateWishList(wishList);
    }

    public Wish findWishById(int wish) {
        return wishListRepository.findWishById(wish);
    }

    public void updateWish(Wish wish) {
        wishListRepository.updateWish(wish);
    }

    public List<Wish> findWishesByWishListId(int wishId) {
        return wishListRepository.findWishesByWishListId(wishId);
    }


}
