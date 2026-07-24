select
    hour(datetime) as hour,
    count(*) as count
from animal_outs
where hour(datetime) >= 9 and hour(datetime) <= 19
group by hour
order by hour


/*
몇시에 입양이 가장 활발 
09 ~ 19

*/