-- 코드를 입력하세요
with recursive time
as (
    select 0 as hour
    union all
    select hour + 1
    from time
    where hour < 23
)
select time.hour, count(animal_id)
from time left join (
        select *, hour(datetime) hour
        from animal_outs) outs
        on time.hour = outs.hour
group by time.hour
order by time.hour