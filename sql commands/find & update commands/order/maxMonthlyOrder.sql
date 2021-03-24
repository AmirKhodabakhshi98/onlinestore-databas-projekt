
--most bought product each month

CREATE PROCEDURE maxMonthlyOrder

AS

SELECT datum, ID, QuantitySold, PName
FROM (
    SELECT
        x.*,
        ROW_NUMBER() OVER(PARTITION BY datum ORDER BY QuantitySold desc) rn --groups in the rows based on year + month. Orders by descending amount of sold product, i.e most sold product is at the top of each such group
    FROM (
        SELECT
            FORMAT(o.[date] , 'yyyy-MM') AS datum , -- formats the date col in Order to the given format, since we only care about monthly/yearly division
            Order_product.Product_id AS ID,
            SUM(Order_product.QuantitySold) AS SumQuantitySold, --
			Product.Name as PName
        FROM [Order] o
        INNER JOIN Order_Product ON o.Order_id= Order_product.Order_id INNER JOIN Product on Product.Product_id = Order_product.Product_id
        GROUP BY  FORMAT(o.[date] , 'yyyy-MM'), Order_product.Product_id, Product.Name
    ) x
) y
WHERE rn = 1

GO




