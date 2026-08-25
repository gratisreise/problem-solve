# 평균대여 기간 7일 이상
# .1f, 기간 내림차, 차id 내림차
select car_id, round(avg((datediff(end_date, start_date)+1)), 1) as average_duration
from car_rental_company_rental_history
group by car_id
having avg((datediff(end_date, start_date)+1)) >= 7
order by average_duration desc, car_id desc