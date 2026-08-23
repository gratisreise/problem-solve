# 2022년 5월 1일 기준
# 5월 1일까지 출고완료 이후 날짜 출고 대기, 미정이면 미정
# 주문id 오름차
select 
    order_id,
    product_id,
    out_date,
    case 
        when out_date <'2022-05-02' then '출고완료'
        when out_date is null then '출고미정'
        else '출고대기'
    end '출고여부'
from food_order 
order by order_id asc 