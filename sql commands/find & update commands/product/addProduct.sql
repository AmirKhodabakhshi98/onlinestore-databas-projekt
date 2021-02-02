CREATE PROCEDURE addProduct

     @Supplier_name nvarchar(50),
     @Name nvarchar(50),
     @Base_price int,
     @Quantity int

AS





    Insert into Product (
        Supplier_name,
        Name,
        Base_price,
        Quantity
    )
    values (
        @Supplier_name,
        @Name,
        @Base_price,
        @Quantity
    )
GO



