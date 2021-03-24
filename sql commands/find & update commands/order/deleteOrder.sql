CREATE PROCEDURE deleteOrder

    @Order_id int,
    @username nvarchar(50)
AS

BEGIN
	BEGIN TRAN
			BEGIN TRY


					UPDATE Product
					SET Product.Quantity = (Product.Quantity +  Order_product.QuantitySold)
					FROM Product INNER JOIN Order_product ON Product.Product_id = Order_product.Product_id
					WHERE Order_product.Order_id = @Order_id

					DELETE Order_product
					FROM [Order_product], [Order]
					WHERE Order_Product.Order_id = @Order_id AND [dbo].[Order].[Confirmed] = 0;

					DELETE FROM [Order]
					WHERE Order_id = @Order_id AND Confirmed = 0 AND username = @username; --checks so order isnt confirmed and belongs to specified user




				COMMIT TRANSACTION


			END TRY
			BEGIN CATCH
				ROLLBACK TRANSACTION
			END CATCH
END

GO
