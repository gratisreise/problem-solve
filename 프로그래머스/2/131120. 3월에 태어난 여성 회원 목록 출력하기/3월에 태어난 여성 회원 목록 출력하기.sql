select member_id, member_name, gender, date_format(date_of_birth, '%Y-%m-%d') as date_of_birth
from member_profile
where month(date_of_birth) = 3 and tlno is not null and gender = 'W'
order by member_id


/*
member_profile
생일 3월, 여성, 
id, 이름, 성별, 생년월일, 
전화번호 null 제외, 
회원id 오름차
*/