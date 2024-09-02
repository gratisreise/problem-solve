/*
- 물고기의 종류별
- 물고기의 이름, 포획수
- 잡은 수 기준 내림차순
1. 물고기의 fishtype 조인
2. fishtype 그룹핑
3. 물고기 이름 설정
*/

SELECT COUNT(*) AS FISH_COUNT, FISH_NAME
FROM FISH_INFO i JOIN FISH_NAME_INFO n
ON i.FISH_TYPE = n.FISH_TYPE
GROUP BY FISH_NAME
ORDER BY FISH_COUNT DESC


