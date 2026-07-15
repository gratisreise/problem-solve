select 
    order_id,
    product_id,
    out_date,
    case 
        when out_date <= '2022-05-01' then '출고완료'
        when out_date > '2022-05-01' then '출고대기'
        else '출고미정'
    end as 출고여부
from food_order 
order by order_id

/*
2022년 5월 1일 기준
까지 = 출고완료, 이후 = 출고 대기, 미정 = 출고미정
주문id 오름차

주문id, 제품id, 출고일자, 출고여부

*/