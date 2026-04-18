package Wishlist.com.project.repository;

import Wishlist.com.project.model.User;
import Wishlist.com.project.model.Wish;
import Wishlist.com.project.model.WishList;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WishlistRepository {

    private final JdbcTemplate jdbcTemplate;

    public WishlistRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    //så vi kan se alle wishes
    public List<Wish> getAllWishes() {
        return jdbcTemplate.query(
                "SELECT * FROM Wish",
                (rs, rowNum) -> new Wish(
                        rs.getInt("wish_id"),
                        rs.getInt("wishlist_id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getString("link"),
                        rs.getBoolean("is_bought")
                )
        );
    }

    public List<User> getAllUsers() {
        return jdbcTemplate.query(
                "SELECT * FROM Users",
                (rs, rowNum) -> new User(
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password")
                )
        );
    }

    public List<WishList> getAllWishLists() {
        return jdbcTemplate.query(
                "SELECT * FROM Wishlist",
                (rs, rowNum) -> new WishList(
                        rs.getInt("wishlist_id"),
                        rs.getInt("user_id"),
                        rs.getString("name")
                )
        );
    }

    public void signupUser(User user){
        String sql = "INSERT INTO Users (name, email, password) VALUES (?,?,?)";

        jdbcTemplate.update(sql,
                user.getName(),
                user.getEmail(),
                user.getPassword());
    }

    public void save(Wish wish) {
        jdbcTemplate.update(
                "INSERT INTO Wish (wishlist_id, title, description, price, link, is_bought) VALUES (?, ?, ?, ?, ?, ?)",
                wish.getWishlistId(),
                wish.getTitle(),
                wish.getDescription(),
                wish.getPrice(),
                wish.getLink(),
                wish.getIsBought()
        );
    }
}