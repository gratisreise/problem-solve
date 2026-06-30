select cart_id
from cart_products
group by cart_id
having sum(name = 'Milk') > 0  and sum(name = 'Yogurt') > 0
order by cart_id

/*
우유 & 요거트 동시 구입했나?
id 오름차

장바구니id,


*/
