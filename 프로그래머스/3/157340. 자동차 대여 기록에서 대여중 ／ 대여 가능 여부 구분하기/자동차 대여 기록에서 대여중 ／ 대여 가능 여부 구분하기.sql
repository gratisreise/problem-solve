# 2022년 10월 16일에 대여면 대여중,  아니면 대여 가능, 
# 당일 반납도 대여중 표시
# 자동차ID 내림차
with cte1 as (
    select car_id, start_date, end_date, 
        case 
            when (start_date < '2022-10-17' and end_date >= '2022-10-16') then 1
            else 0
        end as sign
    from car_rental_company_rental_history
)

select 
    car_id, 
    case 
        when max(sign) = 1 then '대여중'
        else '대여 가능'
    end as availabiltiy

from cte1
group by car_id 
order by car_id desc