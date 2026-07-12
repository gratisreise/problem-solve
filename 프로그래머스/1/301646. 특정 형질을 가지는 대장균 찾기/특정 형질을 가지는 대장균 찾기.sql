select count(*) as count
from ecoli_data
where genotype & 2 = 0 and (genotype & 1 = 1 or genotype & 4 = 4) 



/*
2번 형질 보유x, 1번 or 3번 형질 보유 대장균 개체수


*/