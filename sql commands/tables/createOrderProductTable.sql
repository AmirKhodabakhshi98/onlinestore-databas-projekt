CREATE TABLE Order_product (
    Order_product_id int NOT NULL AUTO_INCREMENT,
    Order_id int NOT NULL,
    Product_id int NOT NULL,
    PRIMARY KEY (Order_product_id),
    FOREIGN KEY (Order_id, Product_id)
)