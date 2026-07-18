select animal_id, name, 
    case
        when sex_upon_intake regexp 'Neutered|Spayed' then 'O'
        else 'X'
    end as 중성화
from animal_ins 
order by animal_id


/*
중성화여부 파악,
Neutered or Spayed 중성화:O else X
아이디 오름차
*/