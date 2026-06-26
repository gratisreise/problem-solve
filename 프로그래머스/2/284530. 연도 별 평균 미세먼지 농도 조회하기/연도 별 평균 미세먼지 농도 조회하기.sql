select year(ym) as year, round(avg(pm_val1), 2) as pm10, round(avg(pm_val2), 2) as `pm2.5`
from AIR_POLLUTION
where location2 = '수원'
group by year(ym)
order by year


/*
수원, 연도별, 
평균 미세먼지 오염도, 평균 초미세먼지 오염도
연도 오름차

PM10, PM2.5(소수셋째자리 반올림)


*/