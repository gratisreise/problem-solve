# 생산일자 2022년 5월, 식품별 총매출 내림차, 식품ID 오름차
select
    p.product_id,
    p.product_name,
    sum(p.price * o.amount) as total_sales
from food_product p join food_order o
on p.product_id = o.product_id
where o.produce_date like '2022-05%'
group by p.product_id
order by total_sales desc, product_id asc