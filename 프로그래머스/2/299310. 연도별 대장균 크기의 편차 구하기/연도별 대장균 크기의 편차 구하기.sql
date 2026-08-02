with pre1 as(
    select 
        id,
        year(differentiation_date) as year,
        max(size_of_colony) over(partition by year(differentiation_date)) as mx,
        size_of_colony as size
    from ecoli_data
)


select 
    year,
    (mx - size) as year_dev,
    id
from pre1
order by year asc, year_dev asc



/*
분화된 연도별, 
연도 오름차, 편차 오름차
편차 = max - 내크기

*/