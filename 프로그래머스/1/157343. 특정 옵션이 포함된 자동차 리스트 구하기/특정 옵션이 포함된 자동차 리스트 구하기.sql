# 네비게이션 옵션, 포함 자동차, id 내림차

select * from car_rental_company_car
where options like '%네비게이션%'
order by car_id desc