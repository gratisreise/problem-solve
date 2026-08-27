# 사원별 성과금 정보, 

with cte1 as( # 사원별 점수
    select e.emp_no, e.emp_name, sal, avg(g.score) as score
    from hr_employees e join hr_grade g
    on e.emp_no = g.emp_no
    group by e.emp_no
)

select 
    emp_no, emp_name,
    case
        when score >= 96 then 'S'
        when score >= 90 then 'A'
        when score >= 80 then 'B'
        else 'C'
    end as grade,
    case
        when score >= 96 then sal * 0.2
        when score >= 90 then sal * 0.15
        when score >= 80 then sal * 0.1
        else 0
    end as bonus
from cte1
order by emp_no asc