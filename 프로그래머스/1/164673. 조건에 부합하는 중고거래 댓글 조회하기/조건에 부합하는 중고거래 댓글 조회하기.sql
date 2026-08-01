select b.title, b.board_id, r.reply_id, r.writer_id, r.contents, r.created_date
from used_goods_board b
join used_goods_reply r
on b.board_id = r.board_id 
where b.created_date like '2022-10%'
order by r.created_date asc, b.title 


/*
2022년 10월 작성된 게시글 
댓글 작성일 기준 오름차, 게시글 제목 오름차
*/