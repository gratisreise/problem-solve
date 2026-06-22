select animal_type, ifnull(name, 'No name') as name, sex_upon_intake
from animal_ins
order by animal_id



/*
NULL => 'No name' 
아이디 오름차, 

생물종, 이름, 성별 및 중성화 여부


*/