/*
- 분기별
- 분화된 대장균의 개체의 총수
- sql문 작성
- 분기별 'Q' 붙이기
- 분기 오름차
1분기 1,2,3 012
2분기 4,5,6 345
3분기 7,8,9 678 
4분기 10,11,12 91011
*/
select concat(
    TRUNCATE((month(DIFFERENTIATION_DATE) - 1) / 3, 0) + 1, 
    'Q') QUARTER, count(*) ECOLI_COUNT
from ECOLI_DATA
group by QUARTER
order by QUARTER
