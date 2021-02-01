CREATE TABLE Order_product (
    Order_product_id int NOT NULL IDENTITY(1,1),
    Order_id int NOT NULL FOREIGN KEY REFERENCES [Order](Order_id),
    Product_id int NOT NULL FOREIGN KEY REFERENCES Product(Product_id),
    PRIMARY KEY (Order_product_id)
)