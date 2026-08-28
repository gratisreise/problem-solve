# Front end 스킬 개발자 조회, id 오름차
select d.id, d.email, d.first_name, d.last_name
from developers d join skillcodes s 
on d.skill_code & s.code = s.code and category = 'Front End'
group by d.id
order by d.id asc 