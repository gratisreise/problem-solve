-- 업그레이드 불가 아이템
-- id 기준 내림차
select i.ITEM_ID, i.ITEM_NAME, i.RARITY
from ITEM_INFO i
left join ITEM_TREE t on i.ITEM_ID = t.PARENT_ITEM_ID
where t.ITEM_ID is null
order by i.ITEM_ID desc
