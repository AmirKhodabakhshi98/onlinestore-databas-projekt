CREATE PROCEDURE findOrdersByUsername
    @Username nvarchar(30)
AS
    SELECT *
    FROM Order
    WHERE Order.Username = @Username
GO