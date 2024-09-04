/*
- 2022년 10월 작성된 게시글
- 게시글 제목, 게시글 ID, 댓글 ID, 댓글 작성자 ID, 댓글 내용, 댓글 작성일
- 작성일 오름차, 게시글 제목 오름차
1. 두테이블 조인
2. 조건에 맞는 컬럼선택
3. 작성일 asc, 제목 asc 정렬
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
          
# SELECT 
#     A.TITLE,
#     A.BOARD_ID,
#     B.REPLY_ID,
#     B.WRITER_ID,
#     B.CONTENTS,
#     DATE_FORMAT(B.CREATED_DATE, '%Y-%m-%d') AS CREATED_DATE
# FROM USED_GOODS_BOARD AS A
#     INNER JOIN USED_GOODS_REPLY AS B
#     ON A.BOARD_ID = B.BOARD_ID
# WHERE A.CREATED_DATE BETWEEN '2022-10-01'
#     AND '2022-10-31'
# ORDER BY CREATED_DATE, TITLE