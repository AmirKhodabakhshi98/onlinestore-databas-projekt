CREATE PROCEDURE PURCHASE

@username nvarchar(50)

AS

BEGIN

	BEGIN TRAN
		BEGIN TRY
				INSERT INTO [Order] (Username)
				VALUES (@username)

				DECLARE @currentOrderID int = (	SELECT TOP 1 Order_id from [Order]
					WHERE Username = @username
					ORDER BY [Order].Order_id DESC)

				INSERT INTO Order_product(Order_id, Product_id, QuantitySold)
				SELECT @currentOrderID, Shopping_Cart_Item.Product_ID, Shopping_Cart_Item.Quantity
				FROM Shopping_Cart_Item
				WHERE Shopping_Cart_Item.Username= @username

				UPDATE Product
				SET Product.Quantity = (Product.Quantity - Shopping_Cart_Item.Quantity)
				FROM Product INNER JOIN Shopping_Cart_Item on Product.Product_id=Shopping_Cart_Item.Product_ID
				WHERE Product.Product_id = Shopping_Cart_Item.Product_ID


				DELETE FROM Shopping_Cart_Item WHERE Shopping_Cart_Item.Username = @username
			COMMIT TRANSACTION

		END TRY
		BEGIN CATCH
			ROLLBACK TRANSACTION
		END CATCH
END


GO