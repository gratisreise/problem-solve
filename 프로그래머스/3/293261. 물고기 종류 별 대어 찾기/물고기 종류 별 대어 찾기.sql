select id, fish_name, length
from fish_info i
join fish_name_info n
on i.fish_type = n.fish_type
where length = (
    select max(length)
    from fish_info
    where fish_type = i.fish_type
)


/*
물고기 종류별, max크기
id 오름차, 

ID, 이름, 길이



*/