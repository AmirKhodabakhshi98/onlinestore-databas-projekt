CREATE PROCEDURE addProduct
    @Product_id int
    @Supplier_name nvarchar(50)
    @Name nvarchar(50)
    @Base_price int
    @Quantity int
AS
    Insert into Product (
        Product_id,
        Supplier_name,
        Name,
        Base_price, 
        Quantity
    )
    values (
        @id,
        @supplier,
        @name, 
        @price
        @quantity
    )
GO