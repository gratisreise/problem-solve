select product_code, sum(p.price * o.sales_amount) as sales
from product p
  join offline_sale o
   on p.product_id = o.product_id 
group by product_code 
order by sales desc, product_code


/*
상품코드별 매출액(판매가 * 판매량)의 합
매출액 내림차, 상품코드 오름차


*/