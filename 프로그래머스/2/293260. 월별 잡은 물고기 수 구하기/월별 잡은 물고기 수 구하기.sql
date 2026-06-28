select count(*) as fish_count, month(time) as month
from fish_info
group by month 
order by month

/*
월별 
잡은 물고기수, 월
월기준 오름차
9이하 두자리 출력x
잡은물고기 없는 월 출력x

*/