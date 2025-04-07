-- 물고기 종류별
-- 가장 큰 물고기
-- 물고기 id 오름차순

select f1.ID, f2.FISH_NAME, f1.LENGTH
from FISH_INFO f1
join FISH_NAME_INFO f2 on f1.FISH_TYPE = f2.FISH_TYPE
where (f1.fish_type, f1.LENGTH) in (
    select fish_type, max(LENGTH)
    from FISH_INFO
    group by FISH_TYPE
)
order by f1.ID
