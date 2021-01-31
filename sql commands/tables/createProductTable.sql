CREATE TABle Product (
    Product_id int NOT NULL AUTO_INCREMENT,
    Supplier_name nvchar(50) NOT NULL,
    Name nvchar(50) NOT NULL,
    Base_price int NOT NULL,
    QUANTITY int NOT NULL,
    PRIMARY KEY (Product_id)
)