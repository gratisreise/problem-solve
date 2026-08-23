# 앞2자리, 카테고리코드 오름차
select 
    left(product_code, 2) as category,
    count(*) as products
from product
group by left(product_code, 2)
order by category asc
