CREATE TABLE household (
                           eircode VARCHAR(10) PRIMARY KEY,
                           address VARCHAR(255)
);

CREATE TABLE pet (
                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                     name VARCHAR(50) NOT NULL,
                     type VARCHAR(50) NOT NULL,
                     age INT NOT NULL,
                     household_eircode VARCHAR(10),
                     FOREIGN KEY (household_eircode) REFERENCES household(eircode)
);
CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(50) NOT NULL,
                       unlocked BOOLEAN DEFAULT TRUE
);