CREATE PROCEDURE purchase

		(@username int)

	AS

	BEGIN TRANSACTION [purchaseTransaction]

				BEGIN TRY

					INSERT INTO [Order](Username) -- sätter i ny order
					VALUES (@username)

					DECLARE cursor1 CURSOR FOR (SELECT Product_id, Quantity FROM Shopping_Cart_Item -- hämtar cart items
						WHERE Shopping_Cart_ID =
						(SELECT TOP 1 ID FROM Shopping_cart
						WHERE Username = @username
						ORDER BY ID DESC) AND UserDeletedItem = 0)

					DECLARE @currentOrderID int = (	SELECT TOP 1 Order_id from [Order] --hämtar order id
					WHERE Username = @username
					ORDER BY [Order].Order_id DESC )

					DECLARE @Product_id int;
					DECLARE @Quantity int;

					WHILE @@FETCH_STATUS = 0
						BEGIN
							FETCH NEXT FROM cursor1
							INTO @Product_id, @Quantity;

							INSERT INTO Order_product
							VALUES (@currentOrderID, @Product_id, @Quantity)

							UPDATE Product
							SET Quantity = Quantity-@Quantity
							WHERE Product_id=@Product_id

					END

			COMMIT TRANSACTION [purchase]

			END TRY

			BEGIN CATCH

				ROLLBACK TRANSACTION [purchase]

			END CATCH

	GO
