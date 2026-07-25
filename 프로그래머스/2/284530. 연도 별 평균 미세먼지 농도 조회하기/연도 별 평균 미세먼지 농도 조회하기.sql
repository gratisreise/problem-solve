select 
    year(ym) as year,
    round(avg(pm_val1), 2) as PM10,
    round(avg(pm_val2), 2) as `pm2.5`
from air_pollution
where location2 like '%수원%'
group by year(ym) 
order by year asc


/*
수원 ,
연도별, 
평균미세먼지 오염도,
소수셋째자리 반올림, 
연도 오름차


*/