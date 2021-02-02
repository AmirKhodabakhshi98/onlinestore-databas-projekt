CREATE PROCEDURE searchProductId


@Id int

AS

    SELECT * FROM Product
    WHERE @Id = Product_id

GO
