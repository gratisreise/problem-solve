/*
- root 아이템 id명, 아이템명 출력
1. item_id로 조인
2. PARENT_ITEM_ID가 null
3. 해당하는 아이템 id와 이름 출력
*/

SELECT I.ITEM_ID, ITEM_NAME
FROM ITEM_INFO I JOIN ITEM_TREE T
ON I.ITEM_ID = T.ITEM_ID
WHERE PARENT_ITEM_ID IS NULL
