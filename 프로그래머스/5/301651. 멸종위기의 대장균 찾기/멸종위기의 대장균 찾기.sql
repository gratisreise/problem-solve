with recursive cte as (
    select id, 1 as generation
    from ecoli_data 
    where parent_id is null
    
    union all
    
    select e.id, c.generation + 1
    from ecoli_data e
    join cte c
    on c.id = e.parent_id 
)

select count(*) as "count", generation 
from cte c
left join ecoli_data e
on c.id = e.parent_id 
where e.parent_id is null
group by generation

# select count(*) as "count", generation
# from cte
# group by generation
# order by 
