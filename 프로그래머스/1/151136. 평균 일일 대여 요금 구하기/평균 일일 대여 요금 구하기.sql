select round(avg(daily_fee), 0) as AVERAGE_FEE
from car_rental_company_car
where car_type = 'SUV'
group by car_type


/*
[조건]
자동차 종류 'SUV'
대여요금 정수만, 
컬럼명 AVERAGE_FEE
[결과값]
평균일일 대여 요금 출력

*/
