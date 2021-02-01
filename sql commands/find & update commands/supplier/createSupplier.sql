CREATE PROCEDURE addSupplier

AS

   DECLARE @Name AS nvarchar(50)
   DECLARE @Phone_number AS int
   DECLARE @Address AS nvarchar(50)

    Insert into Supplier (
        Name, 
        Phone_number, 
        Address
    )
    values(
        @Name, 
        @Phone_number, 
        @Address
    )
GO