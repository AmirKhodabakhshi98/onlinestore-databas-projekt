CREATE PROCEDURE addSupplier
    @Name nvarchar(30)
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