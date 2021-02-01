CREATE PROCEDURE deleteProduct

AS
	Declare @Product_id int

    Delete from Product
    Where Product_id = @Product_id;

GO