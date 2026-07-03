select e1.id, count(e2.parent_id) as child_count
from ecoli_data e1
left join ecoli_data e2
on e1.id = e2.parent_id 
group by id
order by e1.id



/*

id, 자식의 수 


*/