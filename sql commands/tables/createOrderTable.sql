CREATE TABLE [Order] (
    Order_id int NOT NULL IDENTITY(1,1),
    Username nvarchar(50) NOT NULL FOREIGN KEY REFERENCES Customer(Username),
    Confirmed bit NOT NULL DEFAULT 0,
    Date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (Order_id)

)

