CREATE PROCEDURE deleteFromCart

@Product_ID int,
@username nvarchar(50)

AS

    DELETE FROM Shopping_Cart_Item
    WHERE Product_ID = @Product_ID AND Username = @username

GO
