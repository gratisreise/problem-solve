select category, price, product_name
from food_product f1
where price = (
    select max(price)
    from food_product
    where f1.category = category
) and category regexp '과자|국|김치|식용유'
order by price desc


/*
식품분류별, 가격 제일 비싼 식품 
식품분류 = 과자, 국, 김치, 식용유
가격 내림차

분류, 가격, 이름

*/