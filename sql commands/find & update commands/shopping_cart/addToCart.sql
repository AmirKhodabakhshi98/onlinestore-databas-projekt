CREATE PROCEDURE addToCart

@Username nvarchar(50) NOT NULL,
@Product_ID int NOT NULL,
@Quantity int NOT NULL,
@FinalPrice int NOT NULL


AS

    IF @Quantity <= (
                Select Quantity
                from Product
                WHERE  Product_ID=@Product_ID)
    BEGIN
        INSERT INTO Shopping_Cart_Item (Product_ID, Username, Quantity, FinalPrice)
        VALUES(@Product_ID, @Username, @Quantity, @FinalPrice)
    END

GO

