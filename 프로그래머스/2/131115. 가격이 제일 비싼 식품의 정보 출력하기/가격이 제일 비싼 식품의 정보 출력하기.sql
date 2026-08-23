# 가격이 제일 비싼 ,
select product_id, product_name, product_cd, category, price
from food_product
order by price desc
limit 1