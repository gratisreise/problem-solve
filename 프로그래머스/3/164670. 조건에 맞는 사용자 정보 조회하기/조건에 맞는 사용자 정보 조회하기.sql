-- 중고 거래 게시물 3건 이상
-- 사용자 ID, 닉네임, 전체주소, 전화번호
-- 전체 주소는 시, 도로명 주소, 상세 주소가 함께 출력
-- 전화번호 xxx-xxxx-xxxx 
-- 회원 ID를 기준으로 내림차순
select b.WRITER_ID,
    u.NICKNAME,
    concat(CITY, ' ', STREET_ADDRESS1, ' ', STREET_ADDRESS2) as '전체주소',
    concat(left(TLNO, 3),'-',substr(TLNO, 4, 4), '-', right(TLNO, 4)) as '전화번호'
from USED_GOODS_BOARD b
join USED_GOODS_USER u on b.WRITER_ID = u.USER_ID
group by b.WRITER_ID
having count(b.WRITER_ID) >= 3
order by b.WRITER_ID desc

 