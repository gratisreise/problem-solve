select 
    u.user_id,
    u.nickname,
    concat_ws(' ', u.city, u.street_address1,u.street_address2) as 전체주소,
    concat_ws('-', left(u.tlno, 3), substr(u.tlno, 4,4), right(u.tlno, 4)) as 전화번호
from used_goods_user u
where (
    select count(*)
    from used_goods_board
    where writer_id = u.user_id
) >= 3
order by u.user_id desc

/*
중고거래 게시물 3건이상 등록

사용자id, 닉네임, 전체주소, 전화번호


*/