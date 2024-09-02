/*
- 부서별 평균 연봉
- 부서ID, 영문 부서명, 평균 연봉(소수 첫째, 반올림) 컬럼명(AVG_SAL)
- 평균연봉 기준 내림차 정렬
0. 부서id로 조인
1. 부서로 그룹핑
2. 평균연봉컬럼 설정
3. 평균연봉 내림차설정
*/

SELECT D.DEPT_ID, DEPT_NAME_EN, ROUND(AVG(SAL), 0) AS AVG_SAL
FROM HR_DEPARTMENT D JOIN HR_EMPLOYEES E
ON D.DEPT_ID = E.DEPT_ID
GROUP BY D.DEPT_ID
ORDER BY AVG_SAL DESC
