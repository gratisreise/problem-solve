select count(*) fish_count, ni.fish_name
from fish_info i
join fish_name_info ni
on i.fish_type = ni.fish_type
group by i.fish_type
order by fish_count desc 


/*
물고기의 종류별 
물고기 이름, 잡은수
잡은 수 내림차

*/