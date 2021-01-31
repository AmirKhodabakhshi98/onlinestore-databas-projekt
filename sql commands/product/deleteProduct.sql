CREATE deleteProduct
    @Product_id int
AS
    Delete from Product
    Where Product_id = @Product_id;
GO