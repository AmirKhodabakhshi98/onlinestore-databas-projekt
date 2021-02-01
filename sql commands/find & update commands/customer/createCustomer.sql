CREATE PROCEDURE addCustomer 
    @FirstName nvarchar(50),
    @LastName nvarchar(50),
    @Email nvarchar(50),
    @Phone_number int,
    @Country nvarchar(50),
    @City nvarchar(50),
    @Street_address nvarchar(50),
    @Username nvarchar(50),
    @Password nvarchar(50)
AS
    INSERT INTO Customer (
        Firstname,
        Lastname,
        Email,
        Username,
        Password,
        Phone_number,
        Country,
        City,
        Street_address
    )
    VALUES(
        @Firstname,
        @Lastname,
        @Email,
        @Username,
        @Password,
        @Phone_number,
        @Country,
        @City,
        @Street_address
    )
GO