/*
- 대장균 개체의 ID(ID), 자식의 수(CHILD_COUNT)
- 자식 NULL 0출력
- id 오름차
1. group by 
*/

select e1.ID, COUNT(e2.PARENT_ID) CHILD_COUNT
from ECOLI_DATA e1 LEFT JOIN ECOLI_DATA e2
    ON e1.ID = e2.PARENT_ID
GROUP BY e1.ID