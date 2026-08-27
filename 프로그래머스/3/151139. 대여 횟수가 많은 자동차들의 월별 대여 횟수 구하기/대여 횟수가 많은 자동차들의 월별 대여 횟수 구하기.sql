# 대여시작일 2022년 8월 ~ 10월 대여횟수 5회이상 자동차
# 해당 기간 월별, 자동차id별, 총 대여 횟수
# 월 오름차, 자동차id 내림차, 대여횟수 0회는 제외

with cte1 as (
    select car_id from car_rental_company_rental_history
    where start_date >= '2022-08-01' and start_date < '2022-11-01'
    group by car_id
    having count(*) >= 5
)

select month(start_date) month, car_id, count(*) as records
from car_rental_company_rental_history
where start_date >= '2022-08-01' and start_date < '2022-11-01' 
    and car_id in (select car_id from cte1)
group by month(start_date), car_id
order by month asc, car_id desc

