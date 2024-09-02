/*
- 10cm 이하일 경우  길이가 NULL
- 물고기 중 10cm 이하인 물고기의 수
*/

SELECT COUNT(*) AS FISH_COUNT
FROM FISH_INFO
WHERE LENGTH IS NULL