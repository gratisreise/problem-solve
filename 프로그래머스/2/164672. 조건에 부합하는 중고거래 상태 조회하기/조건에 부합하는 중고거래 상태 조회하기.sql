# 2022년 10월 5일에 등록
# 판매중, 예약중, 거래완료, 게시글ID DESC

select board_id, writer_id, title, price,
    case status
        when 'DONE' then '거래완료'
        when 'SALE' then '판매중'
        else '예약중'
    end as `status`
from  used_goods_board
where created_date = '2022-10-05'
order by board_id desc 