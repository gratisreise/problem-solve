-- 평균길이 >= 33
-- 종류별 
-- 종류 오름차
-- null은 10
select 
    count(*) as FISH_COUNT,
    max(IFNULL(LENGTH, 10)) as MAX_LENGTH,
    FISH_TYPE
from FISH_INFO
group by FISH_TYPE
having avg(IFNULL(LENGTH, 10)) >= 33
order by FISH_TYPE