# 이름 = No name
select 
    animal_type, 
    ifnull(name, 'No name') as Name, 
    sex_upon_intake
from animal_ins
order by animal_id asc