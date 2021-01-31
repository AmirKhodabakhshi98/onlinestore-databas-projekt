CREATE PROCEDURE addProductDiscount
    @product_id int
    @discount_id int
    @start_id date
    @end_date date
AS
    Insert into Product_Discount 
    (
        product_id, 
        discount_id, 
        start_id, 
        end_date
    )
    values ( 
        @product_id, 
        @discount_id,
        @start_id, 
        @end_date
    )
GO