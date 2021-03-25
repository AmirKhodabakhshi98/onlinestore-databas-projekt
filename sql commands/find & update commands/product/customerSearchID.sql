CREATE PROCEDURE customerSearchID

@id int
--Method for customer to search for a product based on its ID.
AS

select Product.Product_id, Product.Supplier_name, Product.Name, Product.Base_price, Product.Quantity, Discount.Description, Discount.Percentage
from Product
FULL OUTER JOIN Product_discount
	on Product.Product_id = Product_discount.Product_id
FULL OUTER JOIN Discount
	on Discount.Discount_id = Product_discount.Discount_id
WHERE ((Product_discount.Start_date <= CURRENT_TIMESTAMP AND Product_discount.End_date >= CURRENT_TIMESTAMP)
		OR (Product.Product_id NOT IN (Select Product_discount.Product_id from Product_discount)))
	AND Product.Product_id = @id

GO