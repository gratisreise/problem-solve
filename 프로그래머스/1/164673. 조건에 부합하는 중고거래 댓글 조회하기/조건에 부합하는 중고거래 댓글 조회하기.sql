# 2022년 10월 작성
# 댓글 작성일 오름차, 제목 오름차

select b.title, b.board_id, r.reply_id, r.writer_id, r.contents, r.created_date
from used_goods_board b join used_goods_reply r
on b.board_id = r.board_id 
where b.created_date like '2022-10%'
order by r.created_date asc, b.title asc