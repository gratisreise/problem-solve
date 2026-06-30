select month(start_date) as month, car_id, count(*) as records
from car_rental_company_rentaL_history c1
where 
(select count(*) 
from car_rental_company_rental_history
where start_date >= '2022-08-01' and start_date <= '2022-10-31' and car_id = c1.car_id
group by car_id ) >= 5 and start_date >= '2022-08-01' and start_date <= '2022-10-31'
group by month(start_date), car_id
order by month, car_id desc 


/*
대여시작일기준, 2022년 8월 ~ 2022년 10월
대여횟수 >= 5, 
월별, 자동차id별 
대여횟수

*/