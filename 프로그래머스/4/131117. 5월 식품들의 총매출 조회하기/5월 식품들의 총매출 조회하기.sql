-- 생산일자 2022년 5월
-- 총매출 내림차, ID 오름차
select p.PRODUCT_ID, p.PRODUCT_NAME, 
    sum(o.amount * p.price) as TOTAL_SALES
from FOOD_PRODUCT p
join FOOD_ORDER o on p.PRODUCT_ID = o.PRODUCT_ID
where o.PRODUCE_DATE like '2022-05%'
group by o.PRODUCT_ID
order by TOTAL_SALES desc, p.PRODUCT_ID

