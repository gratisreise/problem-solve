select 
    category,
    price as max_price,
    product_name 
from food_product f
where price = (
    select max(price)
    from food_product
    where f.category = category
) and category in ('과자', '국', '김치', '식용유')
order by max_price desc

/*
식품분류별 제일비싼 식품
분류, 가격, 이름
분류 = 과자,김치,국, 식용유 
가격 내림차

*/