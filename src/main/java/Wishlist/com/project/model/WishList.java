package Wishlist.com.project.model;

public class WishList {
    private int wishListId;
    private int userId;
    private String name;

    public WishList() {
    }

    public WishList(int wishListId, int userId, String name) {
        this.wishListId = wishListId;
        this.userId = userId;
        this.name = name;
    }

    public int getWishListId() {
        return wishListId;
    }

    public void setWishListId(int wishListId) {
        this.wishListId = wishListId;
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
