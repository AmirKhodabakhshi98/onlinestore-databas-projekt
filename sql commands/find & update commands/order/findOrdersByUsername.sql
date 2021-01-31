CREATE PROCEDURE findOrdersByUsername
    @Username nvarchar(50)
AS
    SELECT *
    FROM Order
    WHERE Order.Username = @Username
GO