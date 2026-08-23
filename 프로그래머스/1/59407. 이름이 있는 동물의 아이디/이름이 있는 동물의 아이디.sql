# 이름 있는, id 오름차
select animal_id
from animal_ins
where name is not null
order by animal_id asc 