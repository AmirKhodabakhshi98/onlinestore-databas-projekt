CREATE TABLE Discount (
    Discount_id int NOT NULL IDENTITY(1,1),
    Description nvarchar(50) NOT NULL,
    Percentage float NOT NULL CHECK (0 < Percentage AND Percentage <= 100),
    PRIMARY KEY (Discount_id)
)