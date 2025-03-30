-- 2021년도에 잡은 물고기 수
select count(ID) as FISH_COUNT from fish_info
where TIME like '%2021%'