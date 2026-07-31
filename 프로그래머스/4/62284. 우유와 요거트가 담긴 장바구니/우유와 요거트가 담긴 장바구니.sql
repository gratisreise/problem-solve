select cart_id
from cart_products
group by cart_id
having sum(name = 'Milk') > 0 and sum(name = 'Yogurt') > 0
order by cart_id


/*
우유, 요거트 동시에 구입한 장바구니 확인
아이디 오름차

*/