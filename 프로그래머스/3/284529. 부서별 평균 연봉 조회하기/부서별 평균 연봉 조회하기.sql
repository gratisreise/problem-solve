select d.dept_id, dept_name_en, round(avg(sal), 0) as avg_sal
from hr_department d
 join hr_employees e
 on d.dept_id = e.dept_id
group by d.dept_id
order by avg_sal desc



/*
부서별, 평균연봉
평균연봉 내림차

부서별, 부서ID, 영문 부서명, 평균 연봉(소수점 첫째 반올림) as avg_sal




*/