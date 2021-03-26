CREATE PROCEDURE addToCart

@Username nvarchar(50),
@Product_ID int,
@Quantity int,
@FinalPrice int


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

