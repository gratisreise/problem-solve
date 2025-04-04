-- 100 이하 LOW
-- 100 초과 1000 이하 MEDIUM
-- 1000 초과 'HIGH
-- 개체의 ID 에 대해 오름차순

select ID,
    case
        when SIZE_OF_COLONY <= 100 then 'LOW'
        when SIZE_OF_COLONY > 1000 then 'HIGH'
        else 'MEDIUM'
    end as size
from ECOLI_DATA
order by ID