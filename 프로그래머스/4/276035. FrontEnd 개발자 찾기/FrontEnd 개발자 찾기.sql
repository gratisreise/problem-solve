# front end 개발자 정보조회
select d.id, d.email, d.first_name, d.last_name
from developers d join skillcodes s
on d.skill_code & s.code = s.code
group by d.id
having group_concat(s.category) like '%Front End%'