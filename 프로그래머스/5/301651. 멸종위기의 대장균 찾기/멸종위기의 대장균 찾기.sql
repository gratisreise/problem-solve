with recursive tree as(
    select id, 1 as generation
    from ecoli_data
    where parent_id is null
    
    union all
    
    select e.id, t.generation + 1
    from ecoli_data e
    join tree t
    on e.parent_id = t.id
)

select count(*) as count, generation
from tree t
left join ecoli_data e
on t.id = e.parent_id
where e.parent_id is null
group by generation



/*
세대별 자식이 없는 
개체 수, 세대
세대 오름차

*/