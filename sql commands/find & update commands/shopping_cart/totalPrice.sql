CREATE PROCEDURE totalPrice

@username nvarchar(50)

AS

Select SUM(FinalPrice) AS price
FROM Shopping_Cart_Item
WHERE Username = @username

GO