CREATE PROCEDURE seeDiscountHistoryForAProduct

 @Product_id int

AS

    Select Product_id, Discount.Discount_id, Start_date, End_date, Description, Percentage
    from Product_discount
    join Discount on Discount.Discount_id = Product_discount.Discount_id
    where Product_discount.Product_id = @Product_id

GO

