-- 분기별 균 개체의 총 수
-- 분기별 Q
-- 분기 오름차 정렬
-- 123, 456, 789, 101112
select 
concat(floor((month(DIFFERENTIATION_DATE) - 1) / 3+1), 'Q') as QUARTER,
count(*) as ECOLI_COUNT
from ECOLI_DATA
group by QUARTER
order by QUARTER
