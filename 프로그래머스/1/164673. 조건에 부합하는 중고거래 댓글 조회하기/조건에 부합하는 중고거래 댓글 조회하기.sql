select 
    b.title,
    b.board_id,
    r.reply_id, 
    r.writer_id, 
    r.contents, 
    date_format(r.created_date, '%Y-%m-%d') as created_date
from used_goods_board as b
join used_goods_reply as r
    on b.board_id = r.board_id
where b.created_date between '2022-10-01' and '2022-10-31'
order by created_date, b.title


/*
used_goods_board, used_goods_reply
제목, 게시글id, 댓글id, 댓글 작성자 id, 댓글 내용, 댓글 작성일
2022년 10월 작성
댓글 작성일 오름차, 게시글 제목 오름차 
*/