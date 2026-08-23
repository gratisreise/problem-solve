# 아이디순 
select animal_id, name, date(datetime) as '날짜'
from animal_ins
order by animal_id asc