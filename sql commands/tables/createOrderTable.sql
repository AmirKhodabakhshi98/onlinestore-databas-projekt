CREATE TABLE [Order] (
    Order_id int NOT NULL IDENTITY(1,1),
    Username nvarchar(50) NOT NULL FOREIGN KEY REFERENCES Customer(Username),
    Confirmed bit NOT NULL,
    Date DATETIME NOT NULL,
    PRIMARY KEY (Order_id)

)

