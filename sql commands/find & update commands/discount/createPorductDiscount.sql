CREATE PROCEDURE addProductDiscount

     @Discount_id int,
     @Product_id int,
     @Start_date DATETIME,
     @End_date DATETIME

AS



    Insert into Product_Discount
    (
		Product_id,
        Discount_id,
        Start_date,
        End_date
    )
    values (
	    @Product_id,
        @Discount_id,
        @Start_date,
        @End_date
    )
GO