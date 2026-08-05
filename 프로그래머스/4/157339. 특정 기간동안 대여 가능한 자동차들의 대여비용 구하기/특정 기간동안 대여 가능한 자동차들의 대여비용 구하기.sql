with 
cte1 as (
    select distinct(c.car_id) as car_id, c.car_type
    from car_rental_company_rental_history h
    join car_rental_company_car c
    on h.car_id = c.car_id
    where car_type in ('세단', 'SUV') 
        and c.car_id not in (
            select car_id
            from  car_rental_company_rental_history
            where start_date < '2022-12-01' and end_date >= '2022-11-01'
        )
), 
cte2 as (
    select c.car_id, c.daily_fee * 30 *(1-p.discount_rate/100) as fee
    from car_rental_company_discount_plan p
    join car_rental_company_car c
    on p.car_type = c.car_type
    where duration_type = '30일 이상' and c.car_type in ('세단', 'SUV')
)


# select * from cte2

select c1.car_id, c1.car_type, c2.fee 
from cte1 c1
join cte2 c2
on c1.car_id = c2.car_id
where fee >= 500000 and fee < 2000000
order by c2.fee desc, c1.car_type asc, c1.car_id desc

/*
자동차 종류 = 세단, suv, 
2022년 11월 1일 ~ 11월 30까지 대여 가능 => 대여 기간중 저 날짜 없어야함
30일 간의 대여 금액 50만 이상 200만 미만 
대여 금액 내림차 정렬, 자동차 종류 오름차, 자동차ID 내림차

날짜 + 카 => 세단, suv, 대여 가능한 것만 추리기
할인정보 + 카 => 30* 30할인 * 가격

*/