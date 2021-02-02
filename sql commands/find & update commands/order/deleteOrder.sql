CREATE PROCEDURE deleteOrder

    @Order_id int

AS

    delete from [Order]
    Where Order_id = @Order_id;

GO