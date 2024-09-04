/*
- 2022년도 평가점수(상반기 + 하반기 점수합, SCORE) max 사원
- 점수, 사번, 성명, 직책, 이메일
1. 점수, 사원 조인
2. 평가점수 컬럼 설정
3. 최고점수 조건 설정
*/

SELECT SUM(SCORE) SCORE, E.EMP_NO, EMP_NAME, POSITION, EMAIL
FROM HR_EMPLOYEES E JOIN HR_GRADE G
ON E.EMP_NO = G.EMP_NO
GROUP BY G.EMP_NO
ORDER BY 1 DESC
LIMIT 1
