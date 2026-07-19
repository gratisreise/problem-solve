with 
cars as (
    select car_id
    from car_rental_company_rental_history 
    where start_date <= '2022-11-30' and end_date >= '2022-11-01'
),
fees as (
    select 
        c.car_id, 
        c.car_type,
        30 * c.daily_fee * (1 - discount_rate/100) as fee
    from car_rental_company_car c
    join car_rental_company_discount_plan p
    on c.car_type = p.car_type and p.duration_type = '30일 이상'
    where c.car_type in ('세단', 'SUV')
)

select * 
from fees 
where 500000 <= fee and fee < 2000000 and car_id not in(select * from cars)
order by fee desc, car_type asc, car_id desc


/*
자동차 종류= 세단 or suv 
2022년 11월 1일 ~ 2022년 11월 30일 대여가능
30일간의 대여금액 [50만, 200만),
대여금액 내림차, 자동차 종류 오름차, 자동차ID 내림차

자동차id, 자동차 종류, 대여금액(FEE)

대여 가능한 차들목록 뽑기
각 차들의 하루 할인율이 적용된 하루 비용
조인해서 계산하기
세단 or suv인 것들의 

*/