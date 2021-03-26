CREATE PROCEDURE PURCHASE
--procedure for user purchasing the items in their cart
@username nvarchar(50)

AS

BEGIN

	BEGIN TRAN
		BEGIN TRY
				INSERT INTO [Order] (Username) --create new order
				VALUES (@username)

				DECLARE @currentOrderID int = (	SELECT TOP 1 Order_id from [Order] --get latest orderID for user
					WHERE Username = @username
					ORDER BY [Order].Order_id DESC)

				INSERT INTO Order_product(Order_id, Product_id, QuantitySold)
				SELECT @currentOrderID, Shopping_Cart_Item.Product_ID, Shopping_Cart_Item.Quantity --directly put in the result table from shopping cart item + the latest orderID
				FROM Shopping_Cart_Item
				WHERE Shopping_Cart_Item.Username= @username

				UPDATE Product --lower quantity by the purchased amount
				SET Product.Quantity = (Product.Quantity - Shopping_Cart_Item.Quantity) --decrease quantity with bought amount
				FROM Product INNER JOIN Shopping_Cart_Item on Product.Product_id=Shopping_Cart_Item.Product_ID
				WHERE Product.Product_id = Shopping_Cart_Item.Product_ID


				DELETE FROM Shopping_Cart_Item WHERE Shopping_Cart_Item.Username = @username --clear users cart
			COMMIT TRANSACTION

		END TRY
		BEGIN CATCH
			ROLLBACK TRANSACTION
		END CATCH
END


GO