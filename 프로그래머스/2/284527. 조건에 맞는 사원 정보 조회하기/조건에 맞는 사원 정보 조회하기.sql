select sum(g.score) as score, e.emp_no, emp_name, position, email
from hr_employees e
 join hr_grade g
  on e.emp_no = g.emp_no
group by e.emp_no
having score = (
    select sum(score) score
    from hr_grade
    group by emp_no
    order by score desc
    limit 1
)

/*
2022년도,평가점수 max 사원정보
점수, 사번, 성명, 직책, 이메일 
평가점수 = 상 + 하  as score
*/