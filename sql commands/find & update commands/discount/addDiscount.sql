CREATE PROCEDURE addDiscount
    @Description nvarchar(50)
    @Percentage int
AS
    Insert into Discount (
        description, 
        percentage
    )
    values (
        @Description, 
        @Percentage
    )
GO