with recursive times as (
    select 0 as hour
    
    union all
    
    select hour + 1
    from times
    where hour < 23
)

select t.hour, count(o.animal_id) as "count"
from animal_outs o
right join times t
on t.hour = hour(o.datetime)
group by t.hour 
order by t.hour


/*


*/