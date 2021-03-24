CREATE PROCEDURE findOrderProductsByOrderId

@Order_id int,
@Username nvarchar(50)

AS


select Order_Product.Order_id, Order_Product.Product_id, Product.Name, QuantitySold
from Order_product
JOIN Product on Product.Product_id = Order_Product.Product_id
JOIN [Order] on [Order].Order_id = Order_product.Order_id
where Order_Product.Order_id= @Order_id  AND [Order].Username = @Username


GO

