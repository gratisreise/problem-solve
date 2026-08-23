# 생일 3월, 전화번호 = NULL 제외, 회원 ID 오름차, 여성
select member_id, member_name, gender, date_of_birth
from member_profile
where tlno is not null and month(date_of_birth) = 3 and gender = 'W'
order by member_id asc