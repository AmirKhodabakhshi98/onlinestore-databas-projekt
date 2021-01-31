CREATE TABLE Discount (
    Discount_id int NOT NULL AUTO_INCREMENT,
    Description nvarchar(50) NOT NULL,
    Percentage int NOT NULL CHECK (0 <= Percentage AND Percentage <= 100),
    PRIMARY KEY (Discount_id)
)