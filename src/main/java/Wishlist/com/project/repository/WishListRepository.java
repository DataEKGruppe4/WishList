package Wishlist.com.project.repository;

import Wishlist.com.project.model.User;
import Wishlist.com.project.model.Wish;
import Wishlist.com.project.model.WishList;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public class WishListRepository {

    private final JdbcTemplate jdbcTemplate;

    public WishListRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> findUserForLogin(String email, String password) {
        return jdbcTemplate.query(
                "SELECT * FROM Users WHERE email = ? AND password = ?",
                (rs, rowNum) -> new User(
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password")
                ),
                email, password
        );
    }

    public void signupUser(User user) {
        String sql = "INSERT INTO Users (name, email, password) VALUES (?,?,?)";

        jdbcTemplate.update(sql,
                user.getName(),
                user.getEmail(),
                user.getPassword());
    }


    public void createWish(Wish wish, int wishListId) {
        String sql = "INSERT INTO Wish (wishlist_id, title, description, price, link, is_bought) VALUES (?,?,?,?,?,?)";

        jdbcTemplate.update(sql,
                wishListId,
                wish.getTitle(),
                wish.getDescription(),
                wish.getPrice(),
                wish.getLink(),
                false
        );
    }

    public void updateWish(Wish wish){
        String sql = "UPDATE Wish SET title = ?, description = ?, price = ?, link = ?, is_bought = ? WHERE wish_id = ?";
        jdbcTemplate.update(sql,
                wish.getTitle(),
                wish.getDescription(),
                wish.getPrice(),
                wish.getLink(),
                wish.getIsBought(),
                wish.getWishId());
    }

    public void updateWishList(WishList wishList){
        String sql = "UPDATE Wishlist SET name = ? WHERE wishlist_id = ?";
        jdbcTemplate.update(sql,
                wishList.getName(),
                wishList.getWishListId());
    }

    public void createWishList(WishList wishList, int userId) {
        String sql = "INSERT INTO Wishlist (user_id, name) VALUES (?,?)";

        jdbcTemplate.update(sql,
                userId,
                wishList.getName()
        );
    }

    public void deleteWish(int wishId) {
        String sql = "DELETE FROM Wish WHERE wish_id = ?";

        jdbcTemplate.update(sql, wishId);
    }

    public void deleteWishList(int wishListId){
        String sql ="DELETE FROM Wishlist WHERE wishlist_id = ?";

        jdbcTemplate.update(sql, wishListId);
    }

    public void deleteWishesByWishListId(int wishListId){
        String sql = "DELETE FROM Wish WHERE wishlist_id = ?";
        jdbcTemplate.update(sql, wishListId);
    }

    public void markWishAsBought(int wishId, boolean bought) {
        String sql = "UPDATE Wish SET is_bought = ? WHERE wish_id = ?";
        jdbcTemplate.update(sql, bought, wishId);
    }

    public User findUserById(int userId) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM Users WHERE user_id = ?",
                (rs, rowNum) -> new User(
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password")
                ),
                userId
        );
    }


    public List<WishList> findWishListsByUserId(int userId) {
        return jdbcTemplate.query(
                "SELECT * FROM Wishlist WHERE user_id = ?",
                (rs, rowNum) -> new WishList(
                        rs.getInt("wishlist_id"),
                        rs.getInt("user_id"),
                        rs.getString("name")
                ),
                userId
        );
    }

    public WishList findWishListById(int wishListId) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM Wishlist WHERE wishlist_id = ?",
                (rs, rowNum) -> new WishList(
                        rs.getInt("wishlist_id"),
                        rs.getInt("user_id"),
                        rs.getString("name")
                ),
                wishListId
        );
    }

    public Wish findWishById(int wishId){
        return jdbcTemplate.queryForObject(
                "SELECT * FROM Wish WHERE wish_id = ?",
                (rs, rowNum) -> new Wish(
                        rs.getInt("wish_id"),
                        rs.getInt("wishlist_id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getString("link"),
                        rs.getBoolean("is_bought")
                ),
                wishId
        );
    }


    public List<Wish> findWishesByWishListId(int wishListId) {
        return jdbcTemplate.query(
                "SELECT * FROM Wish WHERE wishlist_id = ?",
                (rs, rowNum) -> new Wish(
                        rs.getInt("wish_id"),
                        rs.getInt("wishlist_id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getString("link"),
                        rs.getBoolean("is_bought")
                ),
                wishListId
        );
    }


}