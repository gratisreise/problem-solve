select 
    route, 
    concat(round(sum(d_between_dist), 1), 'km') as total_distance,
    concat(round(avg(d_between_dist), 2), 'km') as average_distance
from subway_distance
group by route
order by sum(d_between_dist) desc

/*
역 사이 거리 총합
총누계(.1f), 평균역사이거리(.2f) + km
총누계 내림차


*/