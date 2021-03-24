


CREATE PROCEDURE maxMonthlyOrder

AS

SELECT datum, ID, QuantitySold, PName
FROM (
    SELECT
        x.*,
        ROW_NUMBER() OVER(PARTITION BY datum ORDER BY QuantitySold desc) rn
    FROM (
        SELECT
            FORMAT(o.[date] , 'yyyy-MM') AS datum ,
            Order_product.Product_id AS ID,
            SUM(Order_product.QuantitySold) AS QuantitySold,
			Product.Name as PName
        FROM [Order] o
        INNER JOIN Order_Product ON o.Order_id= Order_product.Order_id INNER JOIN Product on Product.Product_id = Order_product.Product_id
        GROUP BY  FORMAT(o.[date] , 'yyyy-MM'), Order_product.Product_id, Product.Name
    ) x
) y
WHERE rn = 1

GO







--    SELECT  t.Year,
--             t.Month,
 --            t.Name AS Name,  t.Product_id ,
  --           MAX(t.sum1) sum2
 --    FROM
 --        (SELECT  YEAR(o.[Date]) AS [Year],
 --                MONTH(o.[Date]) AS [Month],
 --                p.Name AS Name,  p.Product_id ,
 --                SUM(op.QuantitySold) sum1
  --       FROM [Order] o
  --       JOIN [Order_product] op ON op.Order_id=o.Order_id
  --       JOIN Product p ON p.Product_id = op.Product_id
  --       GROUP BY MONTH(o.[Date]), p.Name, YEAR(o.[Date]), p.Product_id) t
  --   WHERE t.Sum1 =
  --       (SELECT MAX(q.Sum1)
 --        FROM (SELECT  YEAR(o.[Date]) AS [Year],
 --                    MONTH(o.[Date]) AS [Month],
 --                    p.Name AS Name,  p.Product_id ,
 --                    SUM(op.QuantitySold) sum1
 --            FROM [Order] o
 --            JOIN [Order_product] op ON op.Order_id=o.Order_id
  --           JOIN Product p ON p.Product_id = op.Product_id
 --            GROUP BY MONTH(o.[Date]), p.Name, YEAR(o.[Date]), p.Product_id) q
 --        WHERE q.Year = t.Year AND q.Month = t.Month)
 --    GROUP BY t.Month, t.Year, t.Name, t.Product_id
 --    ORDER BY t.Year, t.Month



