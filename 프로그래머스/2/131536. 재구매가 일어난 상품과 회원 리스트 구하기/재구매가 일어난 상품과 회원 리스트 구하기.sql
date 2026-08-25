# 동일회원 동일 상품 재구매한 회원,회원ID 오름차, 상품ID 내림차
# 유저별, 상품별 행수가 2 이상이면 
select user_id, product_id
from online_sale 
group by user_id, product_id
having count(*) >= 2
order by user_id asc, product_id desc