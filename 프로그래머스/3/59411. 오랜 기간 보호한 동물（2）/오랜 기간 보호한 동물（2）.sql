select i.animal_id, i.name
from animal_ins i
join animal_outs o
on i.animal_id = o.animal_id
order by datediff(o.datetime, i.datetime) desc
limit 2


/*
입양간 동물, 
보호기간 max 동물 두마리 
아이디, 이름 
보호기간 긴순 

*/