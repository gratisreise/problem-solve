-- 월별 잡은 물고기 수, 월
-- FISH_COUNT, MONTH
-- 월 기준 오름차
-- 없는 달은 제외, 1~12월 형태
select count(*) as FISH_COUNT, month(TIME) as MONTH
from FISH_INFO
group by MONTH
order by MONTH