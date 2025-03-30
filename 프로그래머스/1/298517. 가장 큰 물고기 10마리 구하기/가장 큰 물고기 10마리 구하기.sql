-- 가장큰 10마리 물고기
-- 길이 내림차, 아이디 오름차, null인경우 없음
select id, length from fish_info
order by length desc, id
limit 10