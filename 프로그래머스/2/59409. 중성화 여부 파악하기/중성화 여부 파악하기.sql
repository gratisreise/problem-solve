select animal_id, name,
    case
        when sex_upon_intake regexp 'Spayed|Neutered' then 'O'
        else 'X'
    end as 중성화
from animal_ins
order by animal_id


/*
중성화 여부,
아이디 순 조회 
중성화 => O, 중성화X => X

아이디, 이름, 중성화여부 

*/