-- 3세대 대장균의 ID 출력
-- 2번 조인해서 부모의 부모 id가 not null
select e1.ID
from ECOLI_DATA e1 
join ECOLI_DATA e2 on e1.PARENT_ID = e2.ID
join ECOLI_DATA e3 on e2.PARENT_ID = e3.ID
where e2.PARENT_ID is not null and e3.PARENT_ID is null
order by e1.ID
