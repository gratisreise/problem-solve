select car_id, 
    case 
        when car_id in (
            select car_id 
            from car_rental_company_rental_history
            where '2022-10-16' between start_date and end_date
        ) then '대여중'
        else '대여 가능'
    end as availability
from car_rental_company_rental_history
group by car_id 
order by car_id desc



/*
2022년 10월 16일 대여중 = '대여중' else '대여 가능'
반납날짜가 10월 16일인 경우도 대여중 
자동차id 내림차

*/