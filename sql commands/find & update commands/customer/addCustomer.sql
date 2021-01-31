CREATE PROCEDURE addCustomer 
    @FirstName nvarchar(30)
    @LastName nvarchar(30)
    @Email nvarchar(50)
    @PhoneNumber int
    @Country nvarchar(50)
    @City nvarchar(50)
    @StreetAddress nvarchar(50)
    @Username nvarchar(30)
    @Password nvarchar(30)
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