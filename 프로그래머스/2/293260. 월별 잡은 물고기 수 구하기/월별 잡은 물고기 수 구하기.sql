# 월별 잡은 물고기수, 월 출력
# 월 기준 오름차, 물고기x월 출력x, 앞의 0 없애기
select 
    count(*) as fish_count,
    month(time) as month
from fish_info
group by month(time)
order by month