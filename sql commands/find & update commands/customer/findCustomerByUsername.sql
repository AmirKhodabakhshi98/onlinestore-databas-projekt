CREATE PROCEDURE findCustomerByUsername
    @Username nvarchar(50)
AS
    SELECT *
    FROM Customer
    WHERE Username = @Username
GO