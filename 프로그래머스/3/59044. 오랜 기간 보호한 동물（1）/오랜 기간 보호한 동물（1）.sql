select i.name, i.datetime
from animal_ins i
left join animal_outs o
on i.animal_id = o.animal_id 
where o.animal_id is null
order by i.datetime asc 
limit 3


/*
입양x, 
가장 오래 있던 동물 top3,
이름, 보호시작일
보호시작일 오름차

*/