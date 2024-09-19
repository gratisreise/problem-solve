/*
- 가장 큰 물고기 10마리
- ID, 길이
- 길이 내림차, ID 오름차
- 10cm 이하는 버리기
- 컬럼명 ID, LENGTH 지정
1. where 10보다 큰 조건 설정
2. 길이 기준 내림차 정렬, ID 오름차 정렬
*/
SELECT id,
       length
FROM fish_info
WHERE length > 10
ORDER BY length DESC,
         id LIMIT  10