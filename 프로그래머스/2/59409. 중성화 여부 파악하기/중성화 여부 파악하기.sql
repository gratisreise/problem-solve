# 중성화 여부, Neutered or Spayed, 아이디순
select 
    animal_id,
    name,
    case
        when sex_upon_intake regexp 'Neutered|Spayed' then 'O'
        else 'X'
    end '중성화'
from animal_ins
order by animal_id asc