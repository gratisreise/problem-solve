select
    route,
    concat(round(sum(d_between_dist), 1), 'km') as total_distance,
    concat(round(avg(d_between_dist), 2), 'km') as average_distance
from subway_distance
group by route
order by sum(d_between_dist) desc


/*
노선별 
총누계거리(.2f,km), 평균 역 사이 거리,(.3f,km)
총누계 내림차



*/