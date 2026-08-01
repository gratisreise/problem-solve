select i.id, ni.fish_name, i.length 
from fish_info i
join fish_name_info ni
on i.fish_type = ni.fish_type
where i.length = (
    select max(length)
    from fish_info
    where fish_type = i.fish_type
)
order by i.id asc



/*
물고기 종류별 가장 큰 물고기
id asc, 
id, 이름, 길이 
종류별로 max는 한명, 10cm max는 없음
*/