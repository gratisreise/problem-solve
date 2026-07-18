select 
    year(ym) as year, 
    round(avg(pm_val1), 2) as `PM10`,
    round(avg(pm_val2), 2) as `PM2.5`
from air_pollution
where location2 = '수원'
group by year(ym)
order by year(ym) 



/*
수원, 연도별, 
평균 미오염, 초미오염,
소수셋째 반올림
연도 오름차


*/