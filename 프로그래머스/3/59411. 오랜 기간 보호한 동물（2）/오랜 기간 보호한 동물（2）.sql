-- 입양간 동물
-- 보호 기간 가장 긴 동물
-- 두마리
-- 보호 기간 긴순
select o.animal_id, o.name
from ANIMAL_OUTS o
left join ANIMAL_INS i on i.ANIMAL_ID = o.ANIMAL_ID
order by datediff(o.datetime, i.datetime) desc
limit 2