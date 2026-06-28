select 
    user_id, nickname, 
    concat_ws(' ', city, street_address1, street_address2) as 전체주소,
    concat_ws('-', substring(tlno, 1, 3),substring(tlno, 4, 4), substring(tlno, 8, 4)) as 전화번호
from used_goods_board b
    join used_goods_user u
    on b.writer_id = u.user_id 
group by user_id 
having count(*) >= 3
order by user_id desc 


/*
중고거래 게시물 3건이상 등록한 사용자
사용자id, 닉네임, 전체주소(시,도로명주소,상세주소), 전화번호(xxx-xxxx-xxxx)
회원id 내림차


*/