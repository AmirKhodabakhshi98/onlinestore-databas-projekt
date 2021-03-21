

CREATE PROCEDURE fetchCartItems

(@username nvarchar(50))

AS

SELECT Product_id, Quantity FROM Shopping_Cart_Item
		WHERE Username = @username
GO
