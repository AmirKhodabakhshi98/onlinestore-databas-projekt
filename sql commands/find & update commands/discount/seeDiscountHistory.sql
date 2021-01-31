CREATE PROCEDURE seeDiscountHistory
AS 
    Select *
    from Product_discount p
    join Discount d on d.Discount_id = p.Discount_id
    where p.Product_id = d.percentage
GO