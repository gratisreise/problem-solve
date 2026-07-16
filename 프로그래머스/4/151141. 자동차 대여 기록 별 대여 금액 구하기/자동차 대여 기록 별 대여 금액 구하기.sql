with 
counts as (
    select h.history_id, h.car_id, ifnull(max(discount_rate), 0) as discount
    from car_rental_company_rental_history h
    left join car_rental_company_discount_plan p
    on datediff(end_date, start_date) + 1 >= trim(replace(duration_type, '일 이상', '')) + '0' and car_type = '트럭'
    group by h.history_id, h.car_id
    order by h.history_id
)


select 
    h.history_id,
    cc.daily_fee * (datediff(end_date, start_date) + 1) * (1 - discount/100) as fee
from car_rental_company_rental_history h
join counts c
on h.history_id = c.history_id and h.car_id = c.car_id
join car_rental_company_car cc
on h.car_id = cc.car_id
where cc.car_type = '트럭'
order by fee desc, h.history_id desc 


/*
자동차 종류 = 트럭 
대여기록id, 대여금액
대여금액 내림차, 기록id 내림차


*/