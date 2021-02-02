CREATE TABLE Product_discount (
    Product_id int NOT NULL FOREIGN KEY REFERENCES Product(Product_id) ,
    Discount_id int NOT NULL FOREIGN KEY REFERENCES Discount(Discount_id),
    Start_date DATETIME NOT NULL,
    End_date DATETIME NOT NULL,
    PRIMARY KEY (Product_id, Start_date, End_date)
)