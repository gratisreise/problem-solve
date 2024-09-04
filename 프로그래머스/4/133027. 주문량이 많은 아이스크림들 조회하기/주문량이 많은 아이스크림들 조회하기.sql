/*
- 7월 아이스크림 총 주문량 +상반기 아이스크림 총 주문량
- 상위 3개 

*/
SELECT F.FLAVOR
FROM FIRST_HALF F JOIN JULY J 
    ON F.FLAVOR = J.FLAVOR
GROUP BY J.FLAVOR
ORDER BY (F.TOTAL_ORDER + SUM(J.TOTAL_ORDER)) DESC
LIMIT 3
