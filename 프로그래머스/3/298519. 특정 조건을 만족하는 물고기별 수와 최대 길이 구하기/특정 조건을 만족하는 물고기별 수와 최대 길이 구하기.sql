# 평균길이 33cm 이상, 종류별
select 
    count(*) as fish_count,
    max(ifnull(length, 10)) as max_length,
    fish_type
from fish_info
group by fish_type 
having avg(ifnull(length, 10)) >= 33
order by fish_type asc