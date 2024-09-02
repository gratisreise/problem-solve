/*
- DEVELOPER_INFOS 테이블 Python 스킬 보유자
- 개발자의 ID, 이메일, 이름, 성
- ID를 기준으로 오름차순
1. where로 skill 조건 설정 or
2. id 오름차순
*/

SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPER_INFOS
WHERE SKILL_1 = 'Python' OR SKILL_2 = 'Python' OR SKILL_3 = 'Python'
ORDER BY ID 
