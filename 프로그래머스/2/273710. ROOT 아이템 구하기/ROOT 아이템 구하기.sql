# root 아이템, 아이템id 오름차
select i.item_id, item_name
from item_info i join item_tree t
on i.item_id = t.item_id
where t.parent_item_id is null
order by i.item_id