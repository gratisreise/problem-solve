# 3세대 

with recursive tree as(
    select id, 1 as gen
    from ecoli_data
    where parent_id is null
    
    union all
    
    select e.id, t.gen + 1
    from ecoli_data e join tree t
    on e.parent_id = t.id 
)
select id from tree 
where gen = 3
order by id asc