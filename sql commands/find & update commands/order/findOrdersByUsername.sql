CREATE PROCEDURE findOrdersByUsername
--Get all orders for a specific user
	 @Username nvarchar(50)

AS



    SELECT *
    FROM  [Order]
    WHERE [Order].Username = @Username
GO