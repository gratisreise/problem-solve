select i.animal_id, i.animal_type, i.name
from animal_ins i
 join animal_outs o
  on i.animal_id = o.animal_id
where i.sex_upon_intake like 'Intact%' and o.sex_upon_outcome regexp 'Spayed|Neutered'
order by i.animal_id


/*
중성화 수술한 동물정보
들어올 때 중성화x, 나갈 때 중성화O
아이디 오름차

아이디, 생물종, 이름



*/