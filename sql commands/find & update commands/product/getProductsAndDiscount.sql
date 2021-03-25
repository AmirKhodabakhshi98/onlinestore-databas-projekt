CREATE PROCEDURE getProductsAndDiscount

AS
--procedure for displaying all products and their current discounts

SELECT
Product.Product_id, Product.Supplier_name, Product.Name,
Product.Base_price, Product.Quantity, x.Description, x.Percentage
	FROM Product FULL OUTER JOIN( --join all products and the discount info for those on sale currently
		SELECT Product.Product_id, Discount.Description, Discount.Percentage FROM Product --Select products on discount including discount info
		 JOIN Product_discount
			ON Product.Product_id = Product_discount.Product_id
		 JOIN DISCOUNT
			ON Discount.Discount_id = Product_discount.Discount_id
		WHERE (Product_discount.Start_date <= CURRENT_TIMESTAMP AND Product_discount.End_date >= CURRENT_TIMESTAMP)
)x ON Product.Product_id = x.Product_id

GO