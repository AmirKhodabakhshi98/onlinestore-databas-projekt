CREATE PROCEDURE addProductDiscount
    @Start_id DATETIME
    @End_date DATETIME
AS
    Insert into Product_Discount 
    (
        Start_id,
        End_date
    )
    values (
        @Start_id,
        @End_date
    )
GO