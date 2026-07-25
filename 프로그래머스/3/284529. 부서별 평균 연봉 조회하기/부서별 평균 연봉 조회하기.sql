select  
    d.dept_id,
    d.dept_name_en,
    round(avg(e.sal)) as avg_sal
from hr_department d
join hr_employees e
on d.dept_id = e.dept_id
group by d.dept_id
order by avg_sal desc 

/*
부서별 평균 연봉
부서ID, 영문 부서명, 평균 연봉(정수부분) avg_sal
평균연봉 내림차


*/