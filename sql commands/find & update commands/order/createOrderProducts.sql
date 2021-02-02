CREATE PROCEDURE createOrder
    @Order_id int NOT NULL,
    @Product_id int NOT NULL
AS
    INSERT INTO [Order_product] (
        Order_id,
        Product_id
    )
    VALUES (
        @Order_id,
        @Product_id
    )
GO