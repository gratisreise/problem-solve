select left(product_code, 2) as category, count(*) as products
from product
group by category
order by category


/*
상품코드별(앞 2자리) 상품갯수() 
카테고리 오름차

*/