select animal_type, count(*) as count
from animal_ins
where animal_type in ('Cat', 'Dog')
group by animal_type
order by animal_type

/*
고양이, 개
각각 몇마리 
고양이 먼저

*/