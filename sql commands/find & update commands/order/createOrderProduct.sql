CREATE PROCEDURE createOrderProduct
    @Order_id int NOT NULL,
    @Product_id int NOT NULL

AS
    BEGIN TRANSACTION
        INSERT INTO [Order_product] (
            Order_id,
            Product_id
        )
        VALUES (
            @Order_id,
            @Product_id
        )

        UPDATE Product
        SET Product.Quantity = Product.Quantity - 1
        WHERE Product.Product_id = @Product_id
    END
GO