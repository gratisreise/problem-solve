with recursive times as(
    select 0 as hour
    
    union all
    
    select hour + 1
    from times
    where hour < 23 
)

select hour, count(animal_id) as `count`
from times t left join animal_outs o
on t.hour = hour(o.datetime) 
group by t.hour 
order by hour