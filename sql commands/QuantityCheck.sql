CREATE TRIGGER QuantityCheck
ON Product
FOR INSERT, UPDATE

AS

IF(SELECT MIN (Quantity) FROM Product) < 0

BEGIN

RAISERROR('Not enough in stock',16,1)

ROLLBACK

END