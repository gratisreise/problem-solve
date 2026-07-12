with year_max as (
    select max(size_of_colony) as max_size, year(differentiation_date) as year
    from ecoli_data
    group by year(differentiation_date) 
)

select 
    y.year,
    (max_size - size_of_colony) as  year_dev,
    e.id
from ecoli_data e
join year_max y
on year(e.differentiation_date) = y.year
order by y.year, year_dev 



/*
분화된 연도별 
대장균 크기의 편차

id, year, 
편차 = max - 각 대장균 크기
연도 오름차

*/