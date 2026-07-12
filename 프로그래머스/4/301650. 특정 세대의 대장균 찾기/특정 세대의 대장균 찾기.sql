select e3.id
from ecoli_data e1
join ecoli_data e2
on e1.id = e2.parent_id 
join ecoli_data e3
on e2.id = e3.parent_id
where e1.parent_id is null
order by e3.id



/*
3세대 대장균
ID
오름차
부모의 id랑 id랑 엮고 부모의 id가 null이 아닌 것들 중에 
parent가 null이 아닌 것들을 찾으면 3세대?
나의 부모의 부모가 null이 아니면 3세대

*/