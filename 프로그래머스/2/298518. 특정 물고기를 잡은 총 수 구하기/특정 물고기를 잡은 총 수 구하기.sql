-- BASS & SNAPPER
-- FISH_COUNT
select count(*) as FISH_COUNT
from FISH_INFO i 
left join FISH_NAME_INFO n  on i.FISH_TYPE = n.FISH_TYPE
where n.FISH_NAME in ('BASS', 'SNAPPER')
