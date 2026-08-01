select f.flavor
from first_half f
join (
    select flavor, sum(total_order) as total_order
    from july
    group by flavor
) j
on f.flavor = j.flavor
group by f.flavor 
order by (f.total_order + j.total_order) desc 
limit 3

/*
7월 아이스크림 총 주문량 + 상반기 아이스크림 총 주문량
상위 3개 맛을 조회

*/