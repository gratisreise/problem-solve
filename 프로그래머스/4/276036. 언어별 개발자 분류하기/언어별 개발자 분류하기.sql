select 
    case
        when group_concat(s.name) like '%Python%' and group_concat(category) like '%Front End%' then 'A'
        when group_concat(s.name) like '%C#%' then 'B'
        when group_concat(category) like '%Front End%' then 'C'
        else null
    end as grade,
    id,
    email
from developers d
join skillcodes s
on d.skill_code & s.code >= 1
group by id 
having grade is not null
order by grade, id
/*
A: Front End and Python 
B: C#
C: 그외 front end

skill_code로 조인하고
category를 sum하고 

*/