select car_type, count(*) as cars
from car_rental_company_car
where options regexp '통풍시트|열선시트|가죽시트'
group by car_type
order by car_type



/*
옵션=통풍|열선|가죽 자동차,
종류별
종류 오름차 

몇대

*/