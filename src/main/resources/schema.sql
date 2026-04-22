CREATE TABLE IF NOT EXISTS Users (
                                     user_id INT AUTO_INCREMENT PRIMARY KEY,
                                     name VARCHAR(255),
                                     email VARCHAR(255) UNIQUE,
                                     password VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS WishList (
                                        wishlist_id INT AUTO_INCREMENT PRIMARY KEY,
                                        user_id INT,
                                        name VARCHAR(255),
                                        FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

CREATE TABLE IF NOT EXISTS Wish (
                                    wish_id INT AUTO_INCREMENT PRIMARY KEY,
                                    wishlist_id INT NOT NULL,
                                    title VARCHAR(255) NOT NULL,
                                    description TEXT,
                                    price DECIMAL(15, 2),
                                    link VARCHAR(1000),
                                    is_bought BOOLEAN,
                                    FOREIGN KEY (wishlist_id) REFERENCES WishList(wishlist_id)
                                        ON DELETE CASCADE
);