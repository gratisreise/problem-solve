select 
    order_id,
    product_id,
    out_date,
    case
        when out_date < '2022-05-02' then '출고완료'
        when out_date >= '2022-05-02' then '출고대기'
        else '출고미정'
    end as 출고여부
from food_order 
order by order_id 

/*
2022년 5월 1일
1일까지 출고완료 이후날짜 출고대기  미정 => 출고미정
*/