CREATE PROCEDURE UnconfirmedOrders
AS

Select * from [Order] where Confirmed = 0

GO