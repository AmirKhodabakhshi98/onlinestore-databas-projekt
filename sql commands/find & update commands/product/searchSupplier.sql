CREATE procedure searchSupplier

@Supplier_name nvarchar(50)

as


select * from [dbo].[Product]
where [Supplier_name] = @Supplier_name
go