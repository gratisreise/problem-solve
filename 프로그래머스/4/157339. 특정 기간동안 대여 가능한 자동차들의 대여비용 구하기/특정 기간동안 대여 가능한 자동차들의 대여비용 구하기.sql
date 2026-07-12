select 
    c.car_id,
    c.car_type,
    round(c.daily_fee * 30 * (1 - (p.discount_rate/100))) as fee
from car_rental_company_car c
join car_rental_company_discount_plan p
on c.car_type = p.car_type and p.duration_type = '30일 이상'
where c.car_type in ('세단', 'SUV')
and c.car_id not in(
    select car_id 
    from car_rental_company_rental_history
    where start_date <= '2022-11-30' and end_date >= '2022-11-01'
)
having fee >= 500000 and fee < 2000000
order by fee desc, c.car_type, c.car_id desc



/*


*/