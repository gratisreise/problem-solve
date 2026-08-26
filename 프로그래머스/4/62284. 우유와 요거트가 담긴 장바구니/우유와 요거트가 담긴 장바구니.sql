# 우유 + 요거트 동시 구입 장바구니, 아이디 오름차
select cart_id
from cart_products
group by cart_id
having group_concat(name) like '%Milk%' and group_concat(name) like '%Yogurt%'
order by cart_id asc