CREATE PROCEDURE UnconfirmedOrders
AS

Select * from [Order] where Confirmed = 0 --select all unconfirmed orders

GO