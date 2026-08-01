select
    e.emp_no,
    e.emp_name,
    case
        when avg(g.score) >= 96 then 'S'
        when avg(g.score) >= 90 then 'A'
        when avg(g.score) >= 80 then 'B'
        else 'C'
    end as grade,
    case 
        when avg(g.score) >= 96 then sal * 0.2
        when avg(g.score) >= 90 then sal * 0.15
        when avg(g.score) >= 80 then sal * 0.1
        else sal * 0
    end as bonus
from hr_employees e
join hr_grade g
on e.emp_no = g.emp_no
group by e.emp_no 



/*
사원별 성과금 정보
평가 점수별 등급
등급에 따른 성과금정보
사번 오름차

사번, 성명, 평가등급(grade), 성과금(bonus)



*/