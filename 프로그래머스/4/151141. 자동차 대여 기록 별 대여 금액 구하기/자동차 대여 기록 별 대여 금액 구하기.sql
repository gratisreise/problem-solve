with pre1 as(
    select 
        history_id, 
        datediff(end_date, start_date) + 1 as days,
        (datediff(end_date, start_date)+1) * c.daily_fee as sum_fee
    from car_rental_company_car c
    join car_rental_company_rental_history h
    on c.car_id = h.car_id
    where car_type = '트럭'
), pre2 as(
    select 
        trim(replace(duration_type, '일 이상', '')) + 0 as days,
        (1-discount_rate/100) as discount
    from car_rental_company_discount_plan
    where car_type = '트럭'
)

# select * from pre2

select 
    p1.history_id,
    sum_fee * ifnull(min(discount), 1) as fee
from pre1 p1
left join pre2 p2
on p1.days >= p2.days 
group by p1.history_id 
order by fee desc , p1.history_id desc



/*
자동차 종류 = 트럭
대여기록별  대여금액, 
대여 금액 내림차, 기록id 내림차


*/