# 입양일 오입력, 보호시작 > 입양일, 보호시작오름차
select i.animal_id, i.name
from animal_ins i join animal_outs o
on i.animal_id = o.animal_id
where i.datetime > o.datetime
order by i.datetime asc 