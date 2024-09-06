/*
- 부모의 형질을 모두 보유한 대장균
- id, 형질, 부모 대장균의 형질
- id 오름차
*/
select  b.id, b.GENOTYPE, a.GENOTYPE PARENT_GENOTYPE
from  ECOLI_DATA a join ECOLI_DATA b
 on a.id = b.parent_id and a.GENOTYPE & b.GENOTYPE = a.GENOTYPE
 