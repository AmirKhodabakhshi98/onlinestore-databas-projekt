CREATE TABLE Product_discount (
    Product_id int NOT NULL,
    Discount_id int NOT NULL,
    Start_date DATETIME NOT NULL,
    End_date DATETIME NOT NULL,
    PRIMARY KEY (Product_id, Start_date, End_date),
    FOREIGN KEY (Product_id, Discount_id)
)