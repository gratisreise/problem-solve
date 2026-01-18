select user_id, product_id
from online_sale
group by user_id, product_id
having count(*) >= 2
order by user_id, product_id desc

/*
online_sale
동일한 회원 동일한 상품 재구매
회원id, 상품id, 
회원id 오름차, 상품 id 내림차

상품 마다 자신을 재구매한 유저의 아이디 구하기
group by 2번해서 집계 count 2번 이상이면 출력 

*/