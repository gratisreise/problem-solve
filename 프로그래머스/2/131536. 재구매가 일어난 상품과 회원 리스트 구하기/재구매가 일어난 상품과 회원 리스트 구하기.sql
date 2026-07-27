select user_id, product_id
from online_sale
group by user_id, product_id
having count(*) >= 2
order by user_id asc, product_id desc



/*
동일한 회원 동일한 상품 재구매
재구매 회원 id - 상품ID
회원id 오름차, 상품ID 내림차

회원별 상품별 갯수 2개 이상인 놈들 만 구하고 정렬

*/