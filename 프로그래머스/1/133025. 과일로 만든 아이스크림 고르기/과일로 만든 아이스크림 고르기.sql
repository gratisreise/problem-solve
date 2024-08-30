/*
- 아이스크림 총주문량 > 3000
- 주성분 과일
- 맛 출력
- 총주문량 desc
1. 맛을 기준으로 조인
2. 총주문량 > 3000 and 과일타입
*/
SELECT f.FLAVOR
FROM FIRST_HALF f JOIN ICECREAM_INFO i
ON f.FLAVOR = i.FLAVOR
WHERE TOTAL_ORDER > 3000 
AND INGREDIENT_TYPE = 'fruit_based'
ORDER BY TOTAL_ORDER DESC
