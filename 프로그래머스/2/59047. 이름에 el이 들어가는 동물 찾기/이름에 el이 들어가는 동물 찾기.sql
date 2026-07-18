select animal_id, name 
from animal_ins
where lower(name) like '%el%' and animal_type = 'Dog'
order by name, animal_id
/*
%el%, 
이름 오름차, 아이디 오름차, 대소문자 구분x

*/