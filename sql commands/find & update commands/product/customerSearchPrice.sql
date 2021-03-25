CREATE PROCEDURE customerSearchPrice
@price int

AS

SELECT
Product.Product_id, Product.Supplier_name, Product.Name,
Product.Base_price, Product.Quantity, x.Description, x.Percentage
	FROM Product FULL OUTER JOIN(
		SELECT Product.Product_id, Discount.Description, Discount.Percentage FROM Product
		 JOIN Product_discount
			ON Product.Product_id = Product_discount.Product_id
		 JOIN DISCOUNT
			ON Discount.Discount_id = Product_discount.Discount_id
		WHERE (Product_discount.Start_date <= CURRENT_TIMESTAMP AND Product_discount.End_date >= CURRENT_TIMESTAMP)
)x ON Product.Product_id = x.Product_id
WHERE Product.Base_price = @price

GO