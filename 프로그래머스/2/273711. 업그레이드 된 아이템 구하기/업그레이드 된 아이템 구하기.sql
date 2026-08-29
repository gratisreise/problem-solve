# 희귀도 rare, 다음 업그레이드 탬 나의 부모가 rared인 놈의 ~~~
with ids as(
    select t.item_id
    from item_info i join item_tree t
    on i.item_id = t.parent_item_id
    where i.rarity = 'RARE'
)

select item_id, item_name, rarity
from item_info
where item_id in (select * from ids)
order by item_id desc


