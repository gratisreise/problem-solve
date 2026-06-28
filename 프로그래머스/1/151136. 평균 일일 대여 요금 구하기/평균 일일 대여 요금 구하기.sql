select round(avg(daily_fee), 0) as avrage_fee
from car_rental_company_car
where car_type = 'suv'


/*
자동차종류 = suv, 
평균일일대여요금(소수첫째반올림) as average_fee 


*/