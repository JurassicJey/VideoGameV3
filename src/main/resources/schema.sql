-- Create GameId Embeddable Table (if needed, H2 might handle it implicitly)
CREATE TABLE IF NOT EXISTS GameId (
                                      uuid VARCHAR(255) PRIMARY KEY
    );

-- Create ReviewId Embeddable Table (if needed, H2 might handle it implicitly)
CREATE TABLE IF NOT EXISTS ReviewId (
    uuid VARCHAR(255) PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS UserId (
    uuid VARCHAR(255) PRIMARY KEY
);
CREATE TABLE IF NOT EXISTS AdminId (
    uuid VARCHAR(255) PRIMARY KEY
);



CREATE TABLE users (
    user_id VARCHAR(255) NOT NULL PRIMARY KEY ,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    balance DOUBLE PRECISION NOT NULL
);
-- Create Games Table
CREATE TABLE IF NOT EXISTS games (
                                     game_id VARCHAR(255) PRIMARY KEY, -- Using UUID for GameId
    title VARCHAR(255),
    price DOUBLE,
    release_date TIMESTAMP,
    description VARCHAR(2000), -- Adjusted size
    publisher VARCHAR(255),
    developer VARCHAR(255),
    genre VARCHAR(255),
    game_user_id VARCHAR(255),
    FOREIGN KEY (game_user_id) REFERENCES users(user_id)
    );

-- Create Reviews Table
CREATE TABLE IF NOT EXISTS reviews (
    review_id VARCHAR(255) PRIMARY KEY, -- Using UUID for ReviewId
    comment VARCHAR(2000), -- Adjusted size
    rating VARCHAR(255),
    timestamp TIMESTAMP,
    game_id VARCHAR(255),
    FOREIGN KEY (game_id) REFERENCES games(game_id)
    );

-- Create the admins table
CREATE TABLE admins (
    admin_id VARCHAR(255) NOT NULL PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255)
);

-- Create the orders table
CREATE TABLE orders (
                        order_id VARCHAR(255) NOT NULL,
                        order_date DATETIME,
                        total_price DOUBLE,
                        order_user_id VARCHAR(255),
                        PRIMARY KEY (order_id),
                        FOREIGN KEY (order_user_id) REFERENCES users(user_id)
);

CREATE TABLE carts (
                       cart_id VARCHAR(255) NOT NULL PRIMARY KEY,
                       cart_user_id VARCHAR(255),
                       FOREIGN KEY (cart_user_id) REFERENCES users(user_id)
);

-- Create the Collection Table for the games list in Cart
-- Corresponds to @ElementCollection and @CollectionTable(name = "shopping_cart_game_ids", ...)
CREATE TABLE shopping_cart_game_ids (

                                        cart_id VARCHAR(255) NOT NULL,


                                        game_id VARCHAR(255) NOT NULL,

                                        FOREIGN KEY (cart_id) REFERENCES carts(cart_id) ON DELETE CASCADE,

                                        FOREIGN KEY (game_id) REFERENCES games(game_id));


CREATE TABLE downloads (
                           id              UUID PRIMARY KEY,          -- Corresponds to @Id private UUID id;
                           source_url      VARCHAR(2048) NOT NULL,    -- Corresponds to private String sourceUrl; VARCHAR length can be adjusted
                           download_status VARCHAR(32)   NOT NULL     -- Corresponds to @Enumerated(EnumType.STRING) private DownloadStatus downloadStatus;
    -- VARCHAR length accommodates longest status string (e.g., "DOWNLOADING") plus buffer.
);