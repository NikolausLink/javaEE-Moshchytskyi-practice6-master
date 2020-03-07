CREATE TABLE IF NOT EXISTS users(
    id         INT(11) PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    email      VARCHAR(50) NULL
);
