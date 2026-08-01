with history as (
    select car_id
    from car_rentaL_company_rental_history
    where start_date >= '2022-08-01' and start_date < '2022-11-01'
    group by car_id 
    having count(*) >= 5
)

select 
    month(start_date) as month,
    ch.car_id,
    count(*) as records
from car_rental_company_rental_history ch
join history h
on ch.car_id = h.car_id
where start_date >= '2022-08-01' and start_date < '2022-11-01'
group by month(start_date), ch.car_id
order by month asc, ch.car_id desc


/*
대여 시작일 2022-08 ~ 2022-10 총대여횟수 5회 이상 놈들

월별, 자동차id별 대여횟수 
월 오름차, 자동차ID 내림차
특정 월의 총대여 횟수 0인 결과는 제외

*/