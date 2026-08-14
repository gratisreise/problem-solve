with recursive tree as (
    select id, 1 as generation
    from ecoli_data
    where parent_id is null
    
    union all
    
    select e.id, t.generation + 1
    from ecoli_data e
    join tree t
    on e.parent_id = t.id
)

select id from tree
where generation = 3
order by id



/*
3세대 대장균
ID
오름차
부모의 id랑 id랑 엮고 부모의 id가 null이 아닌 것들 중에 
parent가 null이 아닌 것들을 찾으면 3세대?
나의 부모의 부모가 null이 아니면 3세대

*/