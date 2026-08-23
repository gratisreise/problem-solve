# 9~19, 입양건수 조회, 결과 시간순 정렬

select hour(datetime) as hour, count(*) as `count`
from animal_outs
where hour(datetime) >= 9 and hour(datetime) <= 19
group by hour(datetime) 
order by hour