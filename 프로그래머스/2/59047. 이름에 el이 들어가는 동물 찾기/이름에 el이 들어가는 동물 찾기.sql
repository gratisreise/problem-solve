select animal_id, name
from animal_ins
where lower(name) like '%el%' and animal_type = 'Dog'
order by name, animal_id

/*
이름 el 있음
이름순, 아이디순


*/