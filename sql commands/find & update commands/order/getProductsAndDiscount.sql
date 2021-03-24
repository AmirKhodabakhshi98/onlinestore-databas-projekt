CREATE PROCEDURE getProductsAndDiscount

AS

SELECT Product.Product_id, Product.Supplier_name, Product.Name, Product.Base_price, Product.Quantity, Discount.Description, Discount.Percentage
FROM Product
FULL OUTER JOIN Product_discount
	ON Product.Product_id = Product_discount.Product_id
FULL OUTER JOIN Discount
	ON Discount.Discount_id = Product_discount.Discount_id
WHERE (Product_discount.Start_date <= CURRENT_TIMESTAMP AND Product_discount.End_date >= CURRENT_TIMESTAMP)
	OR (Product.Product_id NOT IN (SELECT Product_discount.Product_id FROM Product_discount))

GO