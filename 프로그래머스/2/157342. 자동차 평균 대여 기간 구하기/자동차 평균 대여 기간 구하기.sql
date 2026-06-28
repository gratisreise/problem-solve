select car_id, 
    round(avg((datediff(end_date, start_date) + 1)), 1) as average_duration
from car_rental_company_rental_history
group by car_id 
having avg((datediff(end_date, start_date) + 1)) >= 7
order by average_duration desc, car_id desc


/*
평균대여 기간 7일 이상인 자동차 

자동차id, 평균대여기간 as average_duration(소수둘째반올림)
평균대여기간 내림차, 자동차id 내림차

*/