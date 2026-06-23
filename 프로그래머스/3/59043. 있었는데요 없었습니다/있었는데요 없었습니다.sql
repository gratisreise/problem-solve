select i.animal_id, i.name
from animal_ins i
 join animal_outs o
    on i.animal_id = o.animal_id
where i.datetime > o.datetime
order by i.datetime


/*
보호 시작일 > 입양일 
보호시작일 오름차
아이디, 이름

*/