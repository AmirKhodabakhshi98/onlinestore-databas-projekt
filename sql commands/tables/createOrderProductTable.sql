CREATE TABLE Order_product (

    Order_id int NOT NULL FOREIGN KEY REFERENCES [Order](Order_id),
    Product_id int NOT NULL FOREIGN KEY REFERENCES Product(Product_id),
    QuantitySold int NOT NULL
    PRIMARY KEY (Order_id, Product_id)
)


