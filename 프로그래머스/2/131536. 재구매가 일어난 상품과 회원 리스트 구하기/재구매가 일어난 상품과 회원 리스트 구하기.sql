select user_id, product_id
from online_sale
group by product_id, user_id 
having count(*) >= 2
order by user_id, product_id desc

/*
동일한 회원, 동일상품 재구매 데이터
회원id 오름차, 상품id 내림차

재구매 회원id, 재구매 상품id 출력



*/