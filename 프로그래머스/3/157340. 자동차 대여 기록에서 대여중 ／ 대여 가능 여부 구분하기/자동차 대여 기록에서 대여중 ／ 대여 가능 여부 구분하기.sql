/*
- 2022년 10월 16일 기준 '대여중','대여 가능'
- 당일도 대여중
- 자동차ID 내림차순
1. 
2022-10-16
*/

# select * from CAR_RENTAL_COMPANY_RENTAL_HISTORY
# order by car_id
SELECT 
    CAR_ID, 
    CASE 
        WHEN COUNT(CASE 
                     WHEN START_DATE <= '2022-10-16' AND END_DATE >= '2022-10-16' 
                     THEN 1 
                     ELSE NULL 
                   END) > 0 
        THEN '대여중' 
        ELSE '대여 가능' 
    END AS AVAILABILITY
FROM  CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
ORDER BY CAR_ID DESC

# select * from CAR_RENTAL_COMPANY_RENTAL_HISTORY
# order by car_id
