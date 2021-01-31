CREATE PROCEDURE seeDiscountHistory
AS 
    Select *
    from Product_discount p
    join Discount on Discount.Discount_id = Product_discount.Discount_id
    where p.Product_id = d.percentage
GO