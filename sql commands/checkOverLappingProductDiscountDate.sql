create function checkDiscountDateOverlap
(
    @productId int,
    @startDate date,
    @endDate date
)
    returns bit
as
begin
    declare @valid bit = 1;

	if exists( select * from Product_discount
	where [Product_id] = @productId
	and @startDate <=  [End_date]
	and @endDate >= [Start_date] )
       set @valid = 0;

    return @valid;
end