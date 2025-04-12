-- 사원별 성과금
-- 사번 오름차
select e.EMP_NO, EMP_NAME, 
    case
        when sum(SCORE)/2 >= 96 then 'S'
        when sum(SCORE)/2 >= 90 then 'A'
        when sum(SCORE)/2 >= 80 then 'B'
        else 'C'
     end GRADE,
     case
        when sum(SCORE)/2 >= 96 then SAL * 0.2
        when sum(SCORE)/2 >= 90 then SAL * 0.15
        when sum(SCORE)/2 >= 80 then SAL * 0.1
        else SAL * 0
     end BONUS
from HR_EMPLOYEES e
join HR_GRADE g on e.EMP_NO = g.EMP_NO
join HR_DEPARTMENT d on e.DEPT_ID = d.DEPT_ID
group by g.EMP_NO
order by e.EMP_NO