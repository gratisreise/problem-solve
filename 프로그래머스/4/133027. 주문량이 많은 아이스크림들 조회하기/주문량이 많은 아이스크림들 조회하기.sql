with half as (
    select flavor, sum(total_order) as total
    from first_half 
    group by flavor 
),
jjuly as (
    select flavor, sum(total_order) as total
    from july
    group by flavor
)

select h.flavor
from half h
join jjuly j 
on h.flavor = j.flavor 
order by (h.total + j.total) desc
limit 3


/*
7월 총주문량 + 상반기 총주문량
내림차 3개
맛


*/