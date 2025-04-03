-- 부서별
-- 평균연봉
-- 부서id, 영문 부서명, 평균 연봉
-- 평균 연봉 소수점 첫째 자리 반올림, 컬럼명:AVG_SAL
-- 평균 연봉 내림차 정렬
select e.DEPT_ID, d.DEPT_NAME_EN, round(avg(SAL), 0) as AVG_SAL
from HR_DEPARTMENT d
join HR_EMPLOYEES e on d.DEPT_ID = e.DEPT_ID
group by e.DEPT_ID
order by AVG_SAL desc