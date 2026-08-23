# 고양이, 개 각각, 마리수, 고양이 먼저
select animal_type, count(*) as `count`
from animal_ins
where animal_type IN ('Cat', 'Dog')
group by animal_type
order by animal_type asc