/*
- 분화된 연도, 분화된 연도별 대장균 크기의 편차, 대장균 개체의 ID
- 편차 = 크기 max - 각 대장균의 크기
- 연도 오름차, 크기 편차 오름차
1. 연도별 max 크기 대장균
2. 같은 연도의 max - 각 크기 컬럼 설정
3. id 오름차순
*/

select 
    year(DIFFERENTIATION_DATE) YEAR,
    (b.mx_size - SIZE_OF_COLONY) YEAR_DEV,
    id
from (
    select *, year(DIFFERENTIATION_DATE) year
    from ECOLI_DATA) a
join  
(select 
    year(DIFFERENTIATION_DATE) year, 
    max(SIZE_OF_COLONY) mx_size
from ECOLI_DATA
group by year) b
on  a.year = b.year
order by 1, 2