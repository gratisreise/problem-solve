select user_id, product_id
from online_sale
group by user_id, product_id
having count(*) >= 2
order by user_id asc, product_id desc


/*
동일회원, 동일상품 재구매 데이터 
회원id asc, 상품id 내림차


재구매 회원id, 재구매 상품id,



*/