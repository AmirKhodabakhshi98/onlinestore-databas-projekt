CREATE PROCEDURE addDiscount
    @Discount_id int
    @Description nvarchar(50)
    @Percentage int
AS
    Insert into Discount (
        discount_id, 
        description, 
        percentage
    )
    values (
        @Discount_id, 
        @Description, 
        @Percentage
    )
GO