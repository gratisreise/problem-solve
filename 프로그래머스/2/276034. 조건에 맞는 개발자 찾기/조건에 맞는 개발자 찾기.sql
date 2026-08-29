# Python or C# 개발자, id 오름차
select d.id, d.email, d.first_name, d.last_name
from developers d join skillcodes s
on d.skill_code & s.code = s.code and (s.name = 'Python' or s.name = 'C#')
group by d.id 
order by d.id asc

