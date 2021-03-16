


SELECT  t.Year,
		t.Month,
		t.Name AS Name,  t.Product_id ,
		MAX(t.sum1) sum2
FROM
	(SELECT  YEAR(o.[Date]) AS [Year],
			MONTH(o.[Date]) AS [Month],
			p.Name AS Name,  p.Product_id ,
			SUM(op.QuantitySold) sum1
	FROM [Order] o
	JOIN [Order_product] op ON op.Order_id=o.Order_id
	JOIN Product p ON p.Product_id = op.Product_id
	GROUP BY MONTH(o.[Date]), p.Name, YEAR(o.[Date]), p.Product_id) t
WHERE t.Sum1 =
	(SELECT MAX(q.Sum1)
	FROM (SELECT  YEAR(o.[Date]) AS [Year],
				MONTH(o.[Date]) AS [Month],
				p.Name AS Name,  p.Product_id ,
				SUM(op.QuantitySold) sum1
		FROM [Order] o
		JOIN [Order_product] op ON op.Order_id=o.Order_id
		JOIN Product p ON p.Product_id = op.Product_id
		GROUP BY MONTH(o.[Date]), p.Name, YEAR(o.[Date]), p.Product_id) q
	WHERE q.Year = t.Year AND q.Month = t.Month)
GROUP BY t.Month, t.Year, t.Name, t.Product_id
ORDER BY t.Year, t.Month
