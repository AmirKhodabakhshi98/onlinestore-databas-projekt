CREATE PROCEDURE addProductDiscount
    @Product_id
    @Start_id DATETIME
    @End_date DATETIME
AS
    Insert into Product_Discount 
    (
        Product_id,
        Start_id,
        End_date
    )
    values (
        @Product_id,
        @Start_id,
        @End_date
    )
GO