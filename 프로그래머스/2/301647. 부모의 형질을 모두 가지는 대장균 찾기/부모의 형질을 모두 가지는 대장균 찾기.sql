select e1.id, e1.genotype, e2.genotype as parent_genotype
from ecoli_data e1
join ecoli_data e2
on e1.parent_id = e2.id and e1.genotype & e2.genotype = e2.genotype
order by e1.id



/*
부모의 형질을 모두 보유 =>
나의 유전형질 & 부모의 유전형질 =부모의 유전형질
나랑 부모랑 조인해서 유전형질 부모인 것 들만 남기기

*/