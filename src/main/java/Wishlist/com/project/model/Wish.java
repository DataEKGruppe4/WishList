package Wishlist.com.project.model;

public class Wish {
    private int wishId;
    private int wishlistId;
    private String title;
    private String description;
    private double price;
    private String link;
    private boolean isBought;

    public Wish() {
    }

    public Wish(int wishId, int wishlistId, String title, String description, double price, String link, boolean isBought) {
        this.wishId = wishId;
        this.wishlistId = wishlistId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.link = link;
        this.isBought = isBought;
    }

    public int getWishId() {
        return wishId;
    }

    public void setWishId(int wishId) {
        this.wishId = wishId;
    }

    public int getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(int wishlistId) {
        this.wishlistId = wishlistId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean getIsBought() {
        return isBought;
    }

    public void setIsBought(boolean isBought) {
        this.isBought = isBought;
    }
}