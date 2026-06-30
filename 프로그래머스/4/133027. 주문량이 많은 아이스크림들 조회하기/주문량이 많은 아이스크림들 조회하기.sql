with 
f as(
    select flavor, sum(total_order) as total
    from first_half
    group by flavor
),
j as(
    select flavor, sum(total_order) as total
    from july
    group by flavor
)

select f.flavor
from f join j on f.flavor = j.flavor
order by (f.total + j.total) desc
limit 3


/*
맛 그룹화 => 총합 => 둘이 조인해서 상위값 모으기


*/