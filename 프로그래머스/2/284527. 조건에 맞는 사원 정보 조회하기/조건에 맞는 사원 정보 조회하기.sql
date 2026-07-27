select 
    sum(g.score) as score,
    e.emp_no,
    e.emp_name,
    e.position,
    e.email
from hr_employees e
join hr_grade g
on e.emp_no = g.emp_no 
group by e.emp_no
order by sum(g.score) desc
limit 1



/*
2022년 한해 평가 점수 max 
사원정보


*/