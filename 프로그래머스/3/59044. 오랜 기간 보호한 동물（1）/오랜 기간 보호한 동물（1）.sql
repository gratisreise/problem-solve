select i.name, i.datetime
from animal_ins i
 left join animal_outs o
    on  i.animal_id = o.animal_id
where o.animal_id is null
order by i.datetime
limit 3


/*
입양x, 가장 오래 보호소 있음, 동물, 3마리, 
이름, 보호시작일 

*/