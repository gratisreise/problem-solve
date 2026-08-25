# 2022년, 평가점수max, 사원들?, 
with cte1 as(
    select emp_no, sum(score) as score
    from hr_grade
    group by emp_no
    order by score desc
    limit 1
)

select c1.score, e.emp_no, e.emp_name, e.position, e.email
from hr_employees e join cte1 c1
on e.emp_no = c1.emp_no