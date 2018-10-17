CREATE PROCEDURE SP_FetchStock
AS
SELECT s.Stock_ID,p.Product_Name,p.Product_Price,s.product_Quantity,c.Category_Name,c.Category_Desc 
FROM Stock s 
INNER JOIN Product p
ON (s.product_ID = p.Product_ID) 
INNER JOIN Category c
ON (p.Category_ID = c.Category_ID)