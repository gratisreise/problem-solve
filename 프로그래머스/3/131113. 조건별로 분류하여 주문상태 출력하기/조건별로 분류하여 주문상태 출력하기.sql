# 2022년 5월 1일, 
# 5월 1일 포함이전 출고완료, 이후 출고 대기, 미정 = 출고 미정
select 
    order_id,
    product_id,
    out_date,
    case 
        when out_date < '2022-05-02' then '출고완료'
        when out_date is null then '출고미정'
        else '출고대기'
    end as '출고여부'
from food_order
order by order_id asc