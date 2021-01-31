CREATE PROCEDURE findCustomerByUsername
    @Username nvarchar(30)
AS
    SELECT *
    FROM Customer
    WHERE Username = @Username
GO