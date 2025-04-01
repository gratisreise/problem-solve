-- 입양 못간 동물, 기간 내림차 3마리
-- 이름, 보호시작일
-- 보호
select i.name, i.datetime
from ANIMAL_INS i
left join ANIMAL_OUTS o on i.ANIMAL_ID = o.ANIMAL_ID
where o.name is null and i.name is not null
order by i.datetime
limit 3

