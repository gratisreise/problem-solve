select count(*) as fish_count, fish_name
from fish_info i
 join fish_name_info n
  on i.fish_type = n.fish_type
group by fish_name 
order by fish_count desc


/*
물고기종류별, 물고기 이름, 잡은수
fish_name, fish_count
잡은수 내림차 


*/