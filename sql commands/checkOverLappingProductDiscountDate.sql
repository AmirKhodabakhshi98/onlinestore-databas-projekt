create function checkDiscountDateOverlap
(
    @productId int,
    @startDate date,
    @endDate date
)
    returns bit
as
begin


    	if(@startDate>@endDate) return 0;

    	if ((select count(*) from Product_discount
    	     where [Product_id] = @productId
        	    and @startDate <=  [End_date]
    	        and @endDate >= [Start_date]) > 1)
           return 0;


    return 1;

end