with recursive tree as(
    select id, parent_id, 1 as gen
    from ecoli_data
    where parent_id is null
    
    union all
    
    select e.id, e.parent_id, t.gen + 1
    from ecoli_data e
    join tree t
    on t.id = e.parent_id 
)

select 
    count(*) as count, 
    gen as generation   
from tree t
where not exists(
    select 1
    from ecoli_data e
    where e.parent_id = t.id
)
group by gen


