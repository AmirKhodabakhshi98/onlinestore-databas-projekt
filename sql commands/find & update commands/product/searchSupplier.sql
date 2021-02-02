CREATE procedure searchSupplier

@Supplier_name nvarchar(50)

as


select [Supplier_name] from [dbo].[Product]
where [Supplier_name] = @Supplier_name
go