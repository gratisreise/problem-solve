select count(*) as "COUNT"
from ecoli_data
where genotype & 2 = 0 and (genotype & 1 >= 1 or genotype & 4 >= 1)



/*
2번 x (1 or 3) 대장균 개체수

*/