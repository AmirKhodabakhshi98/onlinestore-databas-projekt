CREATE TABlE Product (
    Product_id int NOT NULL IDENTITY(1,1),
    Supplier_name nvarchar(50) NOT NULL,
    Name nvarchar(50) NOT NULL,
    Base_price int NOT NULL CHECK (Base_price >=0),
    Quantity int NOT NULL CHECK (Quantity>=0) ,
    PRIMARY KEY (Product_id),
    FOREIGN KEY (Supplier_name REFERENCES Supplier(Name))

)