CREATE PROCEDURE getProductsAndDiscount

AS
--procedure for displaying all products and their current discounts
SELECT Product.Product_id, Product.Supplier_name, Product.Name, Product.Base_price, Product.Quantity, Discount.Description, Discount.Percentage
FROM Product
FULL OUTER JOIN Product_discount --need outer join to also show products not currently on discount
	ON Product.Product_id = Product_discount.Product_id
FULL OUTER JOIN Discount
	ON Discount.Discount_id = Product_discount.Discount_id
WHERE (Product_discount.Start_date <= CURRENT_TIMESTAMP AND Product_discount.End_date >= CURRENT_TIMESTAMP) --check if the product is on discount in the current date.
	OR (Product.Product_id NOT IN (SELECT Product_discount.Product_id FROM Product_discount)) -- alternatively if the product has never been on sale, since the prior condition would then always be false and the product wouldnt be shown

GO