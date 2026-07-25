select distinct(c.car_id) as car_id 
from car_rental_company_car c
join car_rental_company_rental_history h
on c.car_id = h.car_id
where month(start_date) = 10 and c.car_type = '세단'
order by car_id desc

/*
종류 세단, 10월에 대여 시작, 자동차중복x
id 내림차

*/