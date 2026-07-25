select count(*) as fish_count, month(time) as month
from fish_info
group by month(time)
order by month


/*
잡은 물고기 수, 월

월 오름차

*/