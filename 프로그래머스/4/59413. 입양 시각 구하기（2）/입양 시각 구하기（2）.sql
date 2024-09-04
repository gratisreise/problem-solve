with RECURSIVE TIME as(
    select 0 as hour
    union all
    select hour + 1 from time
    where HOUR < 23)
select time.HOUR
     , count(animal_id)
from (select *
     , HOUR(datetime) as hour     
from animal_outs) as outs2
     right join time on outs2.HOUR = time.HOUR
group by time.HOUR
order by time.HOUR