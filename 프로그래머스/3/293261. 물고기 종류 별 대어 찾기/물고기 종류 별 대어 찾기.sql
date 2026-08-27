# 물고기 종류별, max 물고기 , 물고기 id 오름차 ㄴ

with maxs as (
    select 
        *, 
        max(length) over(partition by fish_type) as max_length
    from fish_info 
)

select id, fish_name, length
from maxs mx join fish_name_info ni
on mx.fish_type = ni.fish_type
where mx.length = mx.max_length
order by id asc