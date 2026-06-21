select b.title, b.board_id, r.reply_id, r.writer_id, r.contents, r.created_date
from used_goods_board as b
  join used_goods_reply as r
    on b.board_id = r.board_id
where b.created_date like '2022-10%'
order by r.created_date asc, b.title asc





/*
2022년 10월 작성, 
댓글작성일 asc, 게시글 제목 asc

게시글 제목, 게시글 id, 댓글id, 댓글작성자id, 댓글내용, 댓글 작성일


*/