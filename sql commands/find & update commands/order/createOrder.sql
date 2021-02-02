CREATE PROCEDURE createOrder
    @Username nvarchar(50) NOT NULL
AS
    INSERT INTO [Order] ( Username ) VALUES ( @Username )
GO