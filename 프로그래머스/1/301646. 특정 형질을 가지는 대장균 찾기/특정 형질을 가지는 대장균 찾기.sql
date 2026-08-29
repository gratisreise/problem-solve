# 2번X and 1or3O 개체수, 
select count(*) as `count`
from ecoli_data 
where genotype & 2 = 0 and (genotype & 1 = 1 or genotype & 4 = 4)