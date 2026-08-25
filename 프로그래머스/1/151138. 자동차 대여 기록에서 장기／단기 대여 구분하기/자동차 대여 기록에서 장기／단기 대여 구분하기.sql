# 대여시작일 2022-09, 30일 이상 장기대여 or 단기 대여, 대여기록id 내림차
select 
    history_id, car_id, start_date, end_date,
    case 
        when (datediff(end_date, start_date) + 1) >= 30 then "장기 대여"
        else "단기 대여"
    end as rent_type
from car_rental_company_rental_history
where start_date like '2022-09%'
order by history_id desc