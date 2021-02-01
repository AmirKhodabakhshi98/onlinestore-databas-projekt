CREATE PROCEDURE addSupplier
    @Name nvarchar(50)
    @Phone_number int
    @Address nvarchar(50)
AS
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