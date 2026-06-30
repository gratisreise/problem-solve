select i.item_id, i.item_name, i.rarity
from item_info i
left join item_tree t
on i.item_id = t.parent_item_id
where t.parent_item_id is null
order by i.item_id desc


/*
업그레이드 불가

id, 이름, 희귀도
id 내림차


*/