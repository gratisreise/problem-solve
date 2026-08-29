# max - 크기, 연도 오름차, 크기편차 오름차
with pre1 as (
    select 
        *,
        max(size_of_colony) over(partition by year(differentiation_date)) as maxs
    from ecoli_data
)

select 
    year(differentiation_date) as year,
    (maxs-size_of_colony ) as year_dev,
    id
from pre1
order by year asc, year_dev asc