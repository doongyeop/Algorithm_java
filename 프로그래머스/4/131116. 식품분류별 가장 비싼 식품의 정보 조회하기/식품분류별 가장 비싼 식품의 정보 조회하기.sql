SELECT category,price, product_name
FROM food_product
WHERE price IN (SELECT max(price) FROM food_product GROUP BY category) 
and category IN ('과자', '국', '김치', '식용유')
GROUP BY category
ORDER BY price DESC