/*
- 업글불가 아이템
- 아이템 ID(ITEM_ID), 아이템 명(ITEM_NAME), 아이템의 희귀도(RARITY)
- id 내림차 정렬
- 자식ID 있으면 강화가능
1. left조인 info로 
2. itemid그룹핑
3. count(PARENT_ITEM_ID) = 0 이면 출력
*/
select i.item_id,ITEM_NAME, RARITY
from ITEM_INFO i left join ITEM_TREE t
    ON i.ITEM_ID = t.PARENT_ITEM_ID
where t.item_id is null
group by i.ITEM_ID
order by i.ITEM_ID desc
