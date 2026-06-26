select i.animal_id, i.name
from animal_ins i 
 join animal_outs o
  on i.animal_id = o.animal_id
order by datediff(o.datetime, i.datetime) desc, i.name
limit 2


/*
입양간 동물, 보호기간 가장김, 두마리,
보호기간순 조회
아이디, 이름

*/