-- 몇시에 입양 활발
-- 0~23시 시간대별
-- 입양건수 조회
-- 시간대 오름차
-- MySQL

-- 0부터 23까지의 모든 시간을 생성하는 CTE (Common Table Expression)
WITH RECURSIVE AllHours (HOUR) AS (
    SELECT 0 -- 시작 시간
    UNION ALL
    SELECT HOUR + 1 FROM AllHours WHERE HOUR < 23 -- 23보다 작을 때까지 1씩 더하며 재귀 호출
)
SELECT
    ah.HOUR,
    COUNT(ANIMAL_ID) AS COUNT        
FROM AllHours ah 
left join ANIMAL_OUTS o on ah.HOUR = HOUR(o.DATETIME)
GROUP BY ah.HOUR           
ORDER BY ah.HOUR           