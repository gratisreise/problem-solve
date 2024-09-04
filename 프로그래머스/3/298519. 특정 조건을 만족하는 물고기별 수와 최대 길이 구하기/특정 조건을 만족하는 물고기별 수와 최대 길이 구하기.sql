/*
- 평균길이 33cm이상 물고기
- 종류별로 분류
- 잡은 수, 최대 길이, 물고기의 종류
- 물고기 종류 오름차, 10cm이하 10cm로 취급
1. 물고기타입 그룹핑
2. 물고기수 count, max 물고기 컬럼설정
3. 10cm이하 = 10cm 조건설정
4. type asc 정렬
*/
# SELECT Count(*) FISH_COUNT,
#        Max(IFNULL(length, 10))   MAX_LENGTH,
#        fish_type
# FROM   fish_info
# GROUP  BY fish_type
# HAVING Avg(IFNULL(length, 10)) >= 33

SELECT COUNT(*) FISH_COUNT, MAX(LENGTH) MAX_LENGTH, FISH_TYPE
FROM FISH_INFO 
GROUP BY FISH_TYPE
HAVING avg(CASE WHEN LENGTH <= 10 or LENGTH is null THEN 10 ELSE LENGTH END) >= 33
ORDER BY FISH_TYPE