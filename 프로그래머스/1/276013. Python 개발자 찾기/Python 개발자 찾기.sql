select id, email, first_name, last_name
from developer_infos
where concat_ws(' ', skill_1, skill_2, skill_3) like '%Python%' 
order by id


/*
python 스킬을 가진 개발자의 정보 조회

*/