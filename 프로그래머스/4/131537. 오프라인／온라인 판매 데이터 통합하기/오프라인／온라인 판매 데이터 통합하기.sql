/*
- 2022년 3월 온/오프
- 판매 날짜, 상품ID, 유저ID, 판매량
- 판매일 오름차, 상품id asc, 유저 id asc
*/
select 
    DATE_FORMAT(SALES_DATE, '%Y-%m-%d') SALES_DATE,
    PRODUCT_ID, USER_ID, SALES_AMOUNT
from ONLINE_SALE
where SALES_DATE like '2022-03%'
    union all
select
    DATE_FORMAT(SALES_DATE, '%Y-%m-%d') SALES_DATE,
    PRODUCT_ID, NULL, SALES_AMOUNT
from OFFLINE_SALE
where SALES_DATE like '2022-03%'
order by SALES_DATE, PRODUCT_ID, USER_ID