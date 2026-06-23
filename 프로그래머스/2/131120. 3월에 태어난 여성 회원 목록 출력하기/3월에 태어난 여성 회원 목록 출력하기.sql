select member_id, member_name, gender, date_of_birth
from member_profile
where tlno is not null and gender = 'W' and month(date_of_birth) = 3
order by member_id


/*
생일 3월, 여성, 
전화번호 null 제외 
회원id 오름차

회원id, 이름, 성별, 생년월일

*/