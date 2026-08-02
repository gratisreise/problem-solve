select e1.id, e1.genotype, e2.genotype as parent_genotype
from ecoli_data e1
join ecoli_data e2
on e1.parent_id = e2.id
where e2.genotype & e1.genotype = e2.genotype
order by e1.id

/*
부모 형질 모두 보유 = 부모의 gentype이랑 & 연산시 1이상
id 오름차

*/