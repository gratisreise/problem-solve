# max 물고기, 길이 내림차, id 오름차, 
select id, length
from fish_info
where length is not null
order by length desc, id asc
limit 10