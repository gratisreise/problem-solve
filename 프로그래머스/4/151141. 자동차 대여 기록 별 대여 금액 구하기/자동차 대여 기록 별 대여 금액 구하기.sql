# 종류 = '트럭', 대여금액 내림차, 대여기록id 내림차
# 차 - 히스토리 가격, 히스토리별 - 할인 구간
with cte1 as ( # 차 - 히스토리 - 가격
    select h.history_id, c.car_type, 
    (datediff(end_date, start_date) + 1) * c.daily_fee as totals, 
    datediff(end_date, start_date) + 1 as days
    from car_rental_company_rental_history h
    join car_rental_company_car c
    on h.car_id = c.car_id
    where c.car_type= '트럭'
),
cte2 as ( # 히스토리 - 할인구간
    select 
        c1.history_id, 
        max(ifnull(p.discount_rate, 0)) as rate
    from cte1 c1 left join car_rental_company_discount_plan p
    on c1.car_type = p.car_type 
    and days >= replace(duration_type, '일 이상', '')
    group by c1.history_id 
)

select 
    c1.history_id, 
    c1.totals * (1 - rate / 100) as fee
from cte1 c1 join cte2 c2 
on c1.history_id = c2.history_id
order by fee desc, c1.history_id desc