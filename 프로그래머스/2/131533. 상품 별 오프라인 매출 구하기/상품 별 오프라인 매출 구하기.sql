# 상품코드별, 판매가*판매량 합계, 매출액 내림차, 상품코드 오름차
select
    p.product_code,
    sum((p.price * o.sales_amount)) as sales
from product p join offline_sale o
on p.product_id = o.product_id
group by p.product_id
order by sales desc, p.product_code asc