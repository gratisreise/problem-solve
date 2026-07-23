select 
    left(product_code, 2) as category,
    count(*) as products 
from product
group by left(product_code, 2) 
order by left(product_code, 2)


/*
상품카테고리 코드 앞2자리 별 상품 갯수
코드 오름차 

*/