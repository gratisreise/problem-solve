select distinct(id) as id,  email, first_name, last_name 
from developers d
join skillcodes s
on d.skill_code & s.code >= 1
where s.category = 'Front End'
order by id



/*
front end 스킬 가진 개발자 정보 조회
id오름차


*/