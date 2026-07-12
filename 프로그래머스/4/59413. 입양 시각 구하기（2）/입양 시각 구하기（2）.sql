with recursive time_slots as (
    select 0 as hour
    union all
    select hour + 1
    from time_slots
    where hour + 1 <= 23
)

select t.hour, ifnull(count, 0) as count
from (
    select hour(datetime) as hour, count(*) as count
    from animal_outs 
    group by hour(datetime)
) as ao
right join time_slots t
on ao.hour = t.hour
order by t.hour



/*
몇시에 입양이 가장 활발?

0~ 23
시간대별로 입양이 몇 건이나 발생하는지 조회

0~23 까지의 테이블
해당 테이블에 맞게 group by 해서 조인


*/