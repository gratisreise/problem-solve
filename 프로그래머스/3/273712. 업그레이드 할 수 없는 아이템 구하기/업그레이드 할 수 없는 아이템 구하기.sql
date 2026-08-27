# 업그레이드 불가 아이템 자식이 있는지 확인

select i.item_id, i.item_name, i.rarity
from item_info i left join item_tree t
on i.item_id = t.parent_item_id
where t.item_id is null
order by i.item_id desc