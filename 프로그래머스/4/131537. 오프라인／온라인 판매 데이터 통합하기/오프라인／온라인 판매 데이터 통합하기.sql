-- 2022년 3월 
-- 상품판매 데이터
-- 판매일 오름차, 상품id 오름차, 유저id 오름차

select SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
from ONLINE_SALE
where SALES_DATE like '2022-03%'
union all
select 
date_format(SALES_DATE, "%Y-%m-%d") as SALES_DATE,
PRODUCT_ID, null, SALES_AMOUNT
from OFFLINE_SALE
where SALES_DATE like '2022-03%'
order by SALES_DATE, PRODUCT_ID, USER_ID