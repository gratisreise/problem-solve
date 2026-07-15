select board_id, writer_id, title, price, 
    case 
        when status = 'sale' then '판매중'
        when status = 'done' then '거래완료'
        else '예약중'
    end as 거래상태
from used_goods_board 
where created_date like '2022-10-05'
order by board_id desc



/*
2022년 10월 5일 등록, 
sale => 판매중, reserved => 예약중, done => 거래완료,
게시글id 내림차

게시글id, 작성자id, 게시글제목, 가격, 거래상태

*/