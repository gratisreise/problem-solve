# 완료된 중고거래, 금액 70만이상, 총거래 오름차
select u.user_id, u.nickname, sum(b.price) as total_sales 
from used_goods_board b join used_goods_user u
on b.writer_id = u.user_id
where status = 'DONE'
group by u.user_id
having sum(price) >= 700000
order by total_sales asc 