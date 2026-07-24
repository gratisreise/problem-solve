select member_id, member_name, gender, date_of_birth
from member_profile 
where month(date_of_birth) = 3 and tlno is not null and gender = 'W'
order by member_id 


/*
3월생일, 여성, 
전화번호null 제외
회원id 오름차

*/