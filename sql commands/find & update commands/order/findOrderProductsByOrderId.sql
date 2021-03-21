CREATE PROCEDURE findOrderProductsByOrderId

	 @Order_id int


AS



    SELECT Product.Name
    FROM Product
    WHERE Product_id = (
        SELECT Order_product.Product_id
        FROM Order_product
        WHERE Order_product.Order_id = @Order_id
    )
GO


