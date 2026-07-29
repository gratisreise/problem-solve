select 
    count(*) as fish_count,
    max(ifnull(length, 10)) as max_length,
    fish_type
from fish_info
group by fish_type
having avg(ifnull(length, 10)) >= 33 
order by fish_type asc

/*
평균길이 33이상
종류별 
잡은 수, 최대 길이, 물고기 종류
종류 오름차, 10cm이하 10cm 취급


*/