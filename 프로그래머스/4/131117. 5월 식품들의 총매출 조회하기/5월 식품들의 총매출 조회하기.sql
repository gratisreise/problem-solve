select p.product_id, product_name, sum(amount * price) as total_sales
from food_product p
 join food_order o 
  on p.product_id = o.product_id
where produce_date like '2022-05%'
group by p.product_id
order by total_sales desc, p.product_id 


/*
생산일자 2022년 5월 
식품, 식품id, 식품이름, 총매출
총매출 내림차, 식품id 오름차 


*/