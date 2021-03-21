CREATE PROCEDURE deleteProduct

    @Product_id int NOT NULL

AS

 	DELETE from Product
     WHERE Product_id = @Product_id AND (NOT EXISTS
 		(SELECT*
 		FROM Order_product
 		WHERE Order_product.Product_id= @Product_id))


GO