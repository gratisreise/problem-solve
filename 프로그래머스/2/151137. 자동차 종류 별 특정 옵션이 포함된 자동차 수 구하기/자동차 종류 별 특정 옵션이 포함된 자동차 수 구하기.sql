select 
    car_type,
    count(*) as cars
from car_rental_company_car
where options regexp '통풍시트|열선시트|가죽시트'
group by car_type
order by car_type


/*
통풍or 열선 or 가죽 옵션포함,
자동차종류별, 몇대
종류 오름차

*/