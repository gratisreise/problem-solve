# 이름에 el, 이름순,아이디순정렬, 이름대소구분x, 개
select animal_id, name
from animal_ins
where lower(name) like  '%el%' and animal_type = 'Dog'
order by name asc, animal_id asc
