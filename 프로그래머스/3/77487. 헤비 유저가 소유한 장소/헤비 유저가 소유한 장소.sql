# 공간 둘이상 등록
with cte1 as(
    select 
        *,
        count(id) over(partition by host_id) as cnt
    from places
)

select id, name, host_id
from cte1
where cnt >= 2
order by id asc