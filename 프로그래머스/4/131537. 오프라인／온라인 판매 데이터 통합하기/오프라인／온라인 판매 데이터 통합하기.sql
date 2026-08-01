select sales_date, product_id, user_id, sales_amount
from online_sale
where sales_date like '2022-03%'

union all

select sales_date, product_id, null, sales_amount
from offline_sale
where sales_date like '2022-03%'

order by sales_date asc, product_id asc, user_id asc


/*
2022년 3월 
판매일 오름차, 상품id 오름차, 유저id 오름차

*/