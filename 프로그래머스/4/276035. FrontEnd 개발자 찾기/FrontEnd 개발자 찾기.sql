/*
- 프론트 스킬 가진 개발자 정보 조회
- 개발자의 ID, 이메일, 이름, 성
- ID 오름차 정렬

*/
select id, email, FIRST_NAME, LAST_NAME
from DEVELOPERS a
    join (select * from SKILLCODES
        where CATEGORY = 'Front End') b
        on  a.SKILL_CODE & b.CODE = b.CODE
GROUP BY id, email, first_name, last_name
order by 1

# SELECT
#  d.id
# ,d.email
# ,d.first_name
# ,d.last_name
# FROM 
#  SKILLCODES s
# JOIN
#  DEVELOPERS d
# ON
#  s.code & d.skill_code = s.code
# WHERE
#  s.category = 'Front End'
# GROUP BY
#  d.id, d.email, d.first_name, d.last_name
# ORDER BY
#  1