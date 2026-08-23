# 입양x, 오래 있던 = 작은, 3마리, 보호시작일 오름차
select i.name, i.datetime 
from animal_ins i left join animal_outs o
on i.animal_id = o.animal_id 
where o.animal_id is null
order by i.datetime asc
limit 3