# Python 스킬 가짐, id 오름차
select id, email, first_name, last_name
from developer_infos
where concat_ws('_', skill_1, skill_2, skill_3) like '%Python%'
order by id asc