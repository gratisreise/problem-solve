-- 우유, 요거트 동시 구입
-- 아이디 조회
-- 아이디 오름차
select cart_id
from CART_PRODUCTS
where name = 'Milk' or name = 'Yogurt'
group by cart_id
having count(distinct(name)) >= 2
order by cart_id

