package Wishlist.com.project.repository;

import Wishlist.com.project.model.Wish;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class Wishlistrepo {


    private final JdbcTemplate jdbcTemplate;

    public Wishlistrepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Wish> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM Wish",
                (rs, rowNum) -> new Wish(
                        rs.getInt("id"),
                        rs.getDouble("pris"),
                        rs.getString("titel"),
                        rs.getString("beskrivelse"),
                        rs.getString("link"))
        );
    }

    public void save(Wish wish) {
        jdbcTemplate.update(
                "INSERT INTO wish(id, pris, titel, beskrivelse, link) VALUES (?, ?)",
                wish.getPris(),
                wish.getTitel(),
                wish.getBeskrivelse(),
                wish.getLink());

    }
}
