# 종류 = 세단 or suv, 
# 2022년 11월 1일 ~ 11월 30일 대여가능 
# 30일간 대여금액 [50만, 200만)
# 대여금액 내림차, 종류 오름차, id 내림차
# 대여가능한놈 id, 차별 대여금액  나중에 둘이 조인해서 하면 될듯
with 
cars as (
    select car_id 
    from car_rental_company_car
    where car_id not in (
        select car_id from car_rental_company_rental_history
        where start_date < '2022-12-01' and end_date >= '2022-11-01'
    ) and car_type in ('세단', 'SUV')
),
prices as(
    select 
        c.car_id, c.car_type,
        (c.daily_fee * 30) *(1 - (discount_rate / 100)) as fee
    from car_rental_company_car c join car_rental_company_discount_plan p
    on c.car_type = p.car_type and duration_type = '30일 이상'
)

select c.car_id, p.car_type, p.fee
from cars c join prices p
on c.car_id = p.car_id 
where p.fee >= 500000 and p.fee < 2000000
order by fee desc, car_type asc, c.car_id desc
