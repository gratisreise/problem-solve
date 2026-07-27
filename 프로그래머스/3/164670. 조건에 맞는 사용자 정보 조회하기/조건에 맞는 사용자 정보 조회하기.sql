select
    u.user_id, 
    u.nickname,
    concat_ws(' ', city, street_address1, street_address2) as 전체주소,
    concat_ws('-', left(tlno, 3), substr(tlno, 4, 4), right(tlno, 4)) as 전화번호
from used_goods_board b
join used_goods_user u
on b.writer_id = u.user_id 
group by u.user_id 
having count(*) >= 3
order by u.user_id desc

/*
중고거래 3건 이상,
시+도로명+상세,
xxx-xxxx-xxxx
회원id 내림차


*/