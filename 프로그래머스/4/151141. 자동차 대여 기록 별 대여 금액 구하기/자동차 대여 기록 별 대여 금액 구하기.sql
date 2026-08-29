# 대여기록별 대여금액, 종류 = '트럭', 대여 금액 내림차, 대여 기록ID 내림차
# 기록, 타입, 금액 | 기록 할인율 
with 
prices as (
    select 
        history_id, car_type,
        (datediff(end_date, start_date) + 1) * daily_fee as prices,
        datediff(end_date, start_date) + 1,
        daily_fee
    from car_rental_company_car c join car_rental_company_rental_history h
    on c.car_id = h.car_id
    where car_type = '트럭'
),
rates as (
    select 
        history_id, 
        (1 - (max(ifnull(discount_rate, 0))/100)) rate
    from car_rental_company_rental_history h left join car_rental_company_discount_plan p
    on (datediff(end_date, start_date) + 1) >= replace(p.duration_type, '일 이상', '') and p.car_type = '트럭'
    group by history_id
)


select 
    p.history_id,
    floor(prices * rate) as fee 
from prices p join rates r
on p.history_id = r.history_id 
order by fee desc, p.history_id desc 
