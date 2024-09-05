/*
- DEVELOPERS 테이블 Python or C#
- 개발자의 ID, 이메일, 이름, 성
1. 두테이블 코드로 조인
2. name이 python이거나 c#인 것 조회
3. id 기준 오름차순
*/

SELECT DISTINCT(id), email, FIRST_NAME, LAST_NAME
FROM developers
         JOIN skillcodes ON developers.skill_code & SKILLCODES.CODE
WHERE NAME ="C#" OR NAME ="Python"
ORDER BY ID