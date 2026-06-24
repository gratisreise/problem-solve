select distinct(cc.car_id)
from car_rental_company_car cc
 join car_rental_company_rental_history cr
  on cc.car_id = cr.car_id
where month(start_date) = 10 and cc.car_type = '세단'
order by 1 desc


/*
종류=세단, 10월에 대여시작
자동차id 출력, 중복x, 
내림차 정렬


*/