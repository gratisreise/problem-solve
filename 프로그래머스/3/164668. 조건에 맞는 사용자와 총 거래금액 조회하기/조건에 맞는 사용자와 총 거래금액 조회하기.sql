select user_id, nickname, sum(price) as total_sales
from used_goods_board b
join used_goods_user u 
on b.writer_id = u.user_id 
where status = 'DONE'
group by writer_id 
having sum(price) >= 700000
order by sum(price) asc


/*
완료된, 중고 거래, 총금액 70만 이상,
총거래 금액 오름차
*/