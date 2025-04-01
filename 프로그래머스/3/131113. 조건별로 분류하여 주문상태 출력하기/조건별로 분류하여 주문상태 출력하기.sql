-- 2022년 5월 1일 기준 출고여부 조회
-- null: 출고미정, 5월 1일 이전: 출고완료, 이후: 출고대기
-- 주문id 오름차
select order_id, product_id, 
date_format(out_date, '%Y-%m-%d') as out_date,
case
    when out_date is null then '출고미정'
    when out_date <= '2022-05-01' then '출고완료'
    else '출고대기'
end as '출고여부'
from food_order
order by order_id