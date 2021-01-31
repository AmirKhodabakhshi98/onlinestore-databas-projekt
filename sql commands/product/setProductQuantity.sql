CREATE PROCEDURE setProductQuantity 
    @Product_id int 
    @Quantity int
AS
    Update Product
    Set Quantity = @Quantity
    Where Product_id = @Product_id
GO