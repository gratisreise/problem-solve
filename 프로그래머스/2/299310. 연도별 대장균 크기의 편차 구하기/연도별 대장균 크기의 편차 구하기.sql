-- 연도, 크기 편차, 대장균 개체의 ID
-- 연도별 가장 큰 크기 - 각 대장균의 크기
select 
year(a.DIFFERENTIATION_DATE) as year,
(b.mx -a.SIZE_OF_COLONY) as YEAR_DEV,
ID
from ECOLI_DATA a 
join (
    select year(DIFFERENTIATION_DATE) as year, 
    max(size_of_colony) as mx
    from ECOLI_DATA
    group by year
     ) b on year(a.DIFFERENTIATION_DATE) = b.year
order by year, year_dev
