CREATE PROCEDURE confirmOrder

    @Order_id int


AS

    update [Order]
    set Confirmed = 1
    where Order_id = @Order_id