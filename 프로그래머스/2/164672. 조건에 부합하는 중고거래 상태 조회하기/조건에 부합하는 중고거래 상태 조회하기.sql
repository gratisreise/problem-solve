select board_id, writer_id, title, price, 
    case
        when status = 'DONE' then '거래완료'
        when status = 'SALE' then '판매중'
        else '예약중'
    end as `status`
from used_goods_board
where created_date = '2022-10-05'
order by board_id desc
/*
2022년 10월 5일
중고거래 게시물 
게시글id, 작성자id, 게시글 제목, 가격, 거래상태
거래상태 = sale 판매중, reserved 예약중, DONE 거래완료
게시글id 내림차

*/