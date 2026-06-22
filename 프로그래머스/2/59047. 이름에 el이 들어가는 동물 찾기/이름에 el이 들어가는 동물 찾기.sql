select animal_id, name
from animal_ins
where lower(name) like '%el%' and animal_type = 'Dog'
order by name, animal_id



/*
개, 이름에 el, 
이름 오름차, 아이디, 
대소문자 구분x

아이디, 이름

*/