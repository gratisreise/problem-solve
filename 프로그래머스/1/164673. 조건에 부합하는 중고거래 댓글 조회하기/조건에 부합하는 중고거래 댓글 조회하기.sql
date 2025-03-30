/*
- 2022년 10월 작성된 게시글
- 게시글 제목, 게시글 ID, 댓글 ID, 댓글 작성자 ID, 댓글 내용, 댓글 작성일
- 작성일 오름차, 게시글 제목 오름차
1. 두테이블 조인 설정
2. 게시글 날짜 조건 설정
3. 정렬 조건 설정
4. 날짜형식 지정
*/
SELECT b.title,
       b.board_id,
       r.reply_id,
       r.writer_id,
       r.contents,
       DATE_FORMAT(r.created_date, '%Y-%m-%d') as created_date
FROM   used_goods_board b
       JOIN used_goods_reply r
         ON b.board_id = r.board_id
WHERE b.created_date 
    BETWEEN '2022-10-01' AND '2022-10-31'
ORDER  BY created_date, title