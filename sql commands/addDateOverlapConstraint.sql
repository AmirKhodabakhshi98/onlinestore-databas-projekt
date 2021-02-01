alter table Product_discount with nocheck add constraint
DateOverlap
        check ([dbo].[checkDiscountDateOverlap]([Product_id], [Start_date], [End_date] ) = 1);