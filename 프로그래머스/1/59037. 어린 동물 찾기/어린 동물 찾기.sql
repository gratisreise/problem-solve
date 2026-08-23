# 젋은 동물,아이디 오름차
select animal_id, name
from animal_ins 
where intake_condition != 'Aged'
order by animal_id asc