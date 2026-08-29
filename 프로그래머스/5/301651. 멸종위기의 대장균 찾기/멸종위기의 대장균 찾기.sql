# 세대별 자식없는 = 부모 아이디와 왼조인할 때 null인 놈, 세대 오름차 순
with recursive tree as (
    select id, 1 as generation
    from ecoli_data
    where parent_id is null
    
    union all
    
    select e.id, t.generation + 1
    from tree t join ecoli_data e
    on t.id = e.parent_id
)

select 
    count(*) as `count`,
    t.generation
from tree t left join ecoli_data e
on t.id = e.parent_id 
where e.parent_id is null
group by t.generation 
order by t.generation