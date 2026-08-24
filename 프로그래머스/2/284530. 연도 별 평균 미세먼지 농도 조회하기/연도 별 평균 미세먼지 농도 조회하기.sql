# 수원, 연도별, 평균미세먼지오염도, 초미세먼지오염도, 
# 소수셋째 자리에서 반올림, 연도 오름차
select
    year(ym) as `year`,
    round(avg(pm_val1), 2) as `PM10`,
    round(avg(pm_val2), 2) as `PM2.5`
from air_pollution
where location2 = '수원'
group by year(ym) 
order by year(ym) asc