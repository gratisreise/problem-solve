select i.animal_id, i.animal_type, i.name
from animal_ins i
join animal_outs o
on i.animal_id = o.animal_id 
where i.sex_upon_intake like '%Intact%'  and o.sex_upon_outcome not like '%Intact%'
order by i.animal_id

/*
중성화 수술 거친 동물
들어올 때 중성화x, 나갈 때 중성화O
아이디, 생물종, 이름
아이디 오름차


*/