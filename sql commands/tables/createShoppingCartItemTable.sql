CREATE TABLE Shopping_Cart_Item (

    Product_ID int NOT NULL FOREIGN KEY REFERENCES Product(Product_ID),
    Username nvarchar(50) NOT NULL FOREIGN KEY REFERENCES Customer(Username),
    Quantity int NOT NULL,
    FinalPrice int NOT NULL
    PRIMARY KEY (Product_ID, Username)


)