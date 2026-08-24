# 잡은 물고기, 10cm이하 수
select count(*) as fish_count from fish_info
where length is null