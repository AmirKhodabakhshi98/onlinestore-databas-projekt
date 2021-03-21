CREATE PROCEDURE createOrderProduct
    @Order_id int NOT NULL,
    @Product_id int NOT NULL,
    @Quantity int NOT NULL

AS

    BEGIN TRANSACTION
        IF @Quantity <= (
                    Select Quantity
                    from Product
                    WHERE  Product_ID=@Product_ID)
        BEGIN

            INSERT INTO [Order_product] (
                Order_id,
                Product_id,
                Quantity
            )
            VALUES (
                @Order_id,
                @Product_id
                @Quantity
            )

            UPDATE Product
            SET Product.Quantity = Product.Quantity - @Quantity
            WHERE Product.Product_id = @Product_id

        END
    END
GO