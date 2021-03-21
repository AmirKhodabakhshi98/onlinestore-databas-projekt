CREATE PROCEDURE clearCart

    @username nvarchar(50)


AS

    DELETE * FROM Shopping_Cart_Item
    WHERE Username=@username

GO