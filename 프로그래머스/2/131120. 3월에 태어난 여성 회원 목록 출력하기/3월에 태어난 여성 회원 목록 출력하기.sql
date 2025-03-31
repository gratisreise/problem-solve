-- 생일이 3월인 여성
-- 전화번호 null 제외
-- 회원id 오름차
select MEMBER_ID, MEMBER_NAME, GENDER, 
date_format(DATE_OF_BIRTH, '%Y-%m-%d') as DATE_OF_BIRTH
from MEMBER_PROFILE
where TLNO is not null and month(DATE_OF_BIRTH) =  3 and GENDER = 'W'
order by MEMBER_ID