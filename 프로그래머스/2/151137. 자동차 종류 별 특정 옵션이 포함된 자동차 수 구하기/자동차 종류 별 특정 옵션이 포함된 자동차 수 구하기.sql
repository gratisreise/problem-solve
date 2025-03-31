-- '통풍시트', '열선시트', '가죽시트' 중 하나 이상의 옵션
-- 자동차 종류 별로 몇 대
-- 자동차 수에 대한 컬럼명은 CARS
-- 자동차 종류: 오름차
# select CAR_TYPE, count(CAR_ID) as CARS
# from CAR_RENTAL_COMPANY_CAR
# where OPTIONS like '%통풍시트%' or OPTIONS like '%열선시트%' or OPTIONS like '%가죽시트%'
# order by CAR_TYPE

select car_type, count(*) as cars
from CAR_RENTAL_COMPANY_CAR
where OPTIONS like '%통풍시트%' or OPTIONS like '%열선시트%' or OPTIONS like '%가죽시트%'
group by car_type
order by car_type