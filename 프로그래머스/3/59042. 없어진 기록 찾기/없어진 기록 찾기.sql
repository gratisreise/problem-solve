# 입양기록O & 보호소 들어옴X, ID 오름차 
select o.animal_id, o.name
from animal_outs o left join animal_ins i
on o.animal_id = i.animal_id
where i.animal_id is null
order by o.animal_id asc