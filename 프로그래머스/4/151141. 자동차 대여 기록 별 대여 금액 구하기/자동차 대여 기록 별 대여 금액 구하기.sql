with 
car_rental as (
    select 
        history_id, 
        datediff(end_date, start_date) + 1 as days,
        car_type,
        daily_fee
    from car_rental_company_rental_history h
    join car_rental_company_car c 
    on h.car_id = c.car_id
    where car_type = '트럭'
), 
plan_type as (
    select 
        car_type, 
        trim(replace(duration_type, '일 이상', '')) + 0 as day_type,
        1- (trim(replace(discount_rate, '%', '')) + 0)/100 as discount
    from car_rental_company_discount_plan
    where car_type = '트럭'
)

select 
    history_id,
    ifnull((
        daily_fee*days* min(discount) 
    ), daily_fee * days) as fee
from plan_type p
right join car_rental c
on c.days >= p.day_type
group by history_id
order by fee desc, history_id desc

# select * from CAR_RENTAL_COMPANY_DISCOUNT_PLAN where car_type = '트럭'



/*
자동차 종류 = 트럭
대여기록별-대여금액

대여기록id, 대여금액리스트
대여금액 내림차, id 내림차
3개를 조인해서


*/