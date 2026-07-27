select
    round(avg(daily_fee)) as average_fee
from car_rental_company_car 
where car_type = 'SUV'

/*
자동차 종류 SUV
평균 일일 대여 요금(반올림, 1) => average_fee


*/