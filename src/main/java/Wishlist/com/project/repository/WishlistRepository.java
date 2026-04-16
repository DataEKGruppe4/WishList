package Wishlist.com.project.repository;

import Wishlist.com.project.model.Wish;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WishlistRepository {

    private final JdbcTemplate jdbcTemplate;

    public WishlistRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Wish> findAll() {
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