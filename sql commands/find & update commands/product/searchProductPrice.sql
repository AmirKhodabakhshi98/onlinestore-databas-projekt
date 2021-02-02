CREATE procedure searchProductPrice

@Price int

as


select * from [dbo].[Product]
where [Base_price] = @Price
go