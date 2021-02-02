CREATE procedure searchNameProduct

@Name nvarchar(50)

as


select * from [dbo].[Product]
where [Name] = @Name
go