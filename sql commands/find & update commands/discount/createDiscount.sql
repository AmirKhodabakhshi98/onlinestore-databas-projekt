CREATE PROCEDURE addDiscount

     @Description nvarchar(50),
     @Percentage float

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