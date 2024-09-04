/*
- 우유와 요거트 동시에 구입한 장바구니
- 아이디
- 어아다 오름차
*/
# SELECT CART_ID FROM CART_PRODUCTS
# WHERE NAME = 'Milk' OR NAME = 'Yogurt'
# GROUP BY CART_ID
# HAVING COUNT(CART_ID) >= 2
select CART_ID
from CART_PRODUCTS
WHERE name = 'Milk' OR name = 'Yogurt'
group by CART_ID
HAVING COUNT(DISTINCT(name)) = 2
ORDER BY 1
    