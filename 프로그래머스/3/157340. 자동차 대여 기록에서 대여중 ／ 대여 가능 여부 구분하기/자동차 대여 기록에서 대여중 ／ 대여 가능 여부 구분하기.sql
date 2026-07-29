select 
    car_id,
    case
        when max(
            case 
                when end_date < '2022-10-16' or start_date >= '2022-10-17' then 0
                else 1
            end
        ) = 1 then '대여중'
        else '대여 가능'
    end as availability
from car_rental_company_rental_history
group by car_id 
order by car_id desc


/*
2022년 10월 16일 
대여중  => 대여중, x => 대여가능 
반납날짜 2022-10-16도 대여중으로 표기
자동차id 내림차


*/