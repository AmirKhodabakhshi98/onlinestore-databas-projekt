CREATE TABLE Shopping_Cart_Item (

    ID int NOT NULL IDENTITY(1,1),
    Product_ID int NOT NULL FOREIGN KEY REFERENCES Product(Product_ID),
    Shopping_Cart_ID int NOT NULL FOREIGN KEY REFERENCES Shopping_cart(ID),
    Quantity int NOT NULL,
    UserDeletedItem bit NOT NULL DEFAULT 0

)