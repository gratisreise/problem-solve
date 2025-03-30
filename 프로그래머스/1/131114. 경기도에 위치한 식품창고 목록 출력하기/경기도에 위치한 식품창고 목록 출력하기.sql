-- 냉동시설 Null = N, 창고id 오름차 정렬
select WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, ifnull(FREEZER_YN, 'N') as FREEZER_YN
from food_warehouse
where ADDRESS like '%경기도%'
order by WAREHOUSE_ID