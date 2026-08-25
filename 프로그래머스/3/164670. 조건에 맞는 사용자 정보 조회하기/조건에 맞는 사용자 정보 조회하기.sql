# 게시물 3건이상 등록한 사용자, 전화번호 - 추가, 주소는 합치기, id 내림차
select 
    u.user_id,
    u.nickname,
    concat_ws(' ', city, street_address1, street_address2) as `전체주소`,
    concat_ws('-', left(tlno, 3), substr(tlno, 4, 4), right(tlno, 4)) as `전화번호`
from used_goods_board b join used_goods_user u
on b.writer_id = u.user_id
group by u.user_id 
having count(b.board_id) >= 3
order by u.user_id desc 