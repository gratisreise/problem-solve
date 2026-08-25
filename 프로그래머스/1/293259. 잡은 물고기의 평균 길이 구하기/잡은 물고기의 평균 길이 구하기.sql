# 잡은 물고기 평균 길이
select 
    round(avg(ifnull(length, 10)), 2) as average_length
from fish_info