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

-- Create Games Table
CREATE TABLE IF NOT EXISTS games (
    game_id VARCHAR(255) PRIMARY KEY, -- Using UUID for GameId
    title VARCHAR(255),
    price DOUBLE,
    release_date TIMESTAMP,
    description VARCHAR(2000), -- Adjusted size
    publisher VARCHAR(255),
    developer VARCHAR(255),
    genre VARCHAR(255)
    );

CREATE TABLE users (
    user_id VARCHAR(255) NOT NULL PRIMARY KEY ,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    balance DOUBLE PRECISION NOT NULL
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