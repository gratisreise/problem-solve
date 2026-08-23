# 12세 이하, 여자, 전화번호x = 'NONE', 나이내림차, 환자오름차
select 
    pt_name, pt_no, gend_cd, age, 
    ifnull(tlno, 'NONE') as tlno
from patient
where age <= 12 and gend_cd = 'W'
order by age desc, pt_name asc