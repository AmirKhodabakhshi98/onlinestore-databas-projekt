CREATE PROCEDURE newOrder

(@username nvarchar(50))

AS

INSERT INTO [Order](Username)
VALUES (@username)

DECLARE @currentOrderID int = (	SELECT TOP 1 Order_id from [Order]
	WHERE Username = @username
	ORDER BY [Order].Order_id DESC)

RETURN @currentOrderID;

