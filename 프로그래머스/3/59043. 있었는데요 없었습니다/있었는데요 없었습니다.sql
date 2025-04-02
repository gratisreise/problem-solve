-- 보호 시작일 > 입양일
-- 보호 시작일 오름차
select i.animal_id, i.name
from ANIMAL_INS i
join ANIMAL_OUTS o on i.ANIMAL_ID = o.ANIMAL_ID
where i.datetime > o.datetime
order by i.datetime
