# 식품분류별, ['과자', '국', '김치', '식용유'], 식품가격 내림차
with maxs as(
    select category, price, product_name, 
        max(price) over(partition by category order by price desc) as max_price
    from food_product
)

select category, max_price, product_name
from maxs
where price = max_price and category in ('과자', '국', '김치', '식용유')
order by max_price desc