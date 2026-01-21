select
    date_format(sales_date, '%Y-%m-%d') as sales_date,
    product_id,
    user_id,
    sales_amount
from online_sale
where year(sales_date) = 2022 and month(sales_date) = 3

union all

select
    date_format(sales_date, '%Y-%m-%d') as sales_date,
    product_id,
    NULL as user_id,
    sales_amount
from offline_sale
where year(sales_date) = 2022 and month(sales_date) = 3

order by 
    sales_date asc,
    product_id asc,
    user_id asc
    


/*
online_sale, offline_sale
2022년 3월 온/오프 상품 판매데이터
판매날짜, 상품id, 유저id, 판매량
오프란인 user_id는 null로 표시
판매일 오름차, 상품ID 오르마, 유저ID 오름차

*/
