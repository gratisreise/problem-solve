select d.id, d.email, d.first_name, d.last_name
from developers d
join skillcodes s
on d.skill_code & s.code >= 1 and s.category = 'Front End'
group by d.id
order by d.id 


/*
front end 스킬 가진 개발자 정보
id 오름차

*/