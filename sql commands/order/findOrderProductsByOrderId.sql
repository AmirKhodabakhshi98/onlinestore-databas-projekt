CREATE PROCEDURE findOrderProductsByOrderId
    @Order_id int
AS
    SELECT Product.Name
    FROM Product
    WHERE Product_id = (
        SELECT Order_Products.Product_id
        FROM Order_Products
        WHERE Order_Products.Order_id = @Order_id
    )
GO