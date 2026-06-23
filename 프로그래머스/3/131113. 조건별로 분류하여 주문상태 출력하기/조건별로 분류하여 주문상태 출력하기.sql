select order_id, product_id, out_date,
case 
    when out_date is null then '출고미정'
    when out_date <= '2022-05-01' then '출고완료'
    else '출고대기'
end as 출고여부
from food_order 
order by order_id


/*
2022년 5월 1일까지 출고완료 이후 출고대기 , NULL = 출고미정
주문id 오름차

주문id, 제품id, 출고일자, 출고여부

*/