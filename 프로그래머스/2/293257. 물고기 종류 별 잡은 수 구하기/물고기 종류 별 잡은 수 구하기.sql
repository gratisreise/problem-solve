# 물고기 종류별, 잡은 수, 잡은수 내림차
select 
    count(*) as fish_count,
    ni.fish_name
from fish_info i join fish_name_info ni
on i.fish_type = ni.fish_type
group by i.fish_type
order by fish_count desc