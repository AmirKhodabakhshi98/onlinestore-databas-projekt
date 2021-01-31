CREATE TABLE Customer (
    Username nvarchar(30) NOT NULL,
    Email nvarchar(50) NOT NULL,
    Password nvarchar(50) NOT NULL,
    Firstname nvarchar(50) NOT NULL,
    Lastname nvarchar(50) NOT NULL,
    Phone_number int NOT NULL,
    Country nvarchar(50) NOT NULL,
    City nvarchar(50) NOT NULL,
    Street_address nvarchar(50) NOT NULL,
    PRIMARY KEY (Username)
)