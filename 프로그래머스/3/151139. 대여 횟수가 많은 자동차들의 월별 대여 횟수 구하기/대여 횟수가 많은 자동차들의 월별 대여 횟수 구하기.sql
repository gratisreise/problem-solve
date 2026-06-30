with car as (
    select car_id
    from car_rental_company_rental_history
    where start_date >= '2022-08-01'
      and start_date < '2022-11-01'
    group by car_id
    having count(*) >= 5
)

select 
    month(start_date) as month,
    h.car_id,
    count(*) as records
from car_rental_company_rental_history h
join car c 
on h.car_id = c.car_id 
where start_date >= '2022-08-01'
  and start_date < '2022-11-01'
group by month(start_date), h.car_id
order by month, h.car_id desc