CREATE PROCEDURE deleteFromCart

@Product_ID

AS

    DELETE FROM Shopping_Cart_Item
    WHERE Product_ID = @Product_ID

GO
