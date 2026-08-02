select d.id, d.email, d.first_name, d.last_name
from developers d
left join skillcodes s
on d.skill_code & s.code >= 1 
group by d.id
having sum(s.name = 'Python') >= 1 or sum(s.name = 'C#') >= 1
order by id asc


/*
python or C#
id 오름차

*/