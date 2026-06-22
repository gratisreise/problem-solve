select animal_id, name, date_format(datetime, '%Y-%m-%d') as `날짜`
from animal_ins
order by animal_id

/*
아이디순 

동물의 아이디, 이름, 들어온 날짜 

*/