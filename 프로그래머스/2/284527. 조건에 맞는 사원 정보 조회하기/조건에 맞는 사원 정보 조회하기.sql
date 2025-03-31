-- 2022년 평가 점수가 가장 높은 사원
-- 상,하반기 점수의 합
select 
sum(g.SCORE)as SCORE, e.EMP_NO, e.EMP_NAME, e.POSITION, e.EMAIL
from HR_EMPLOYEES e 
left join HR_GRADE g on e.EMP_NO = g.EMP_NO
group by e.EMP_NO 
order by SCORE desc
limit 1

