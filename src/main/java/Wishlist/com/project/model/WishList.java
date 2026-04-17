package Wishlist.com.project.model;

public class WishList {
    private int wishlistID;
    private int userId;
    private String name;

    public WishList(int wishlistID, int userId, String name) {
        this.wishlistID = wishlistID;
        this.userId = userId;
        this.name = name;
    }

    public int getWishlistID() {
        return wishlistID;
    }

    public void setWishlistID(int wishlistID) {
        this.wishlistID = wishlistID;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
