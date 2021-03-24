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

        -- if a product already exists in the sales date period, return false, else return true.
        -- its >1 because the way sql server works it will count itself, i.e the input will be counted as 1.
    	if ((select count(*) from Product_discount
    	     where [Product_id] = @productId
        	    and @startDate <=  [End_date]
    	        and @endDate >= [Start_date]) > 1)
           return 0;


    return 1; --if no active discount for this product return true.

end