/*
- 대여 시작일 2022-08 ~ 2022-10
- 대여 회수 >= 5 자동차
- 해당 기간 동안 월별 자동차 ID별 총 대여횟수
- 월 오름차, 자동차 ID 내림차
- 특정월 대여 횟수 0인 경우 제외
1. 2022-08 ~ 2022-10 해당 기간 5번 이상 조건 서브쿼리 설정
2. 그룹핑 MONTH, CAR_ID
3. count(*) 기록 컬럼 설정
4. 월 asc, 자동차id desc
*/
select MONTH(start_date) MONTH, CAR_ID, COUNT(*) RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE CAR_ID IN(
    SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
    GROUP BY CAR_ID
    HAVING COUNT(*) >= 5
) AND START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
GROUP BY MONTH, CAR_ID
ORDER BY 1 , 2 DESC

# SELECT month(START_DATE) as 'MONTH', CAR_ID, count(*) as 'RECORDS'
# from CAR_RENTAL_COMPANY_RENTAL_HISTORY
# where CAR_ID in (select CAR_ID
#                   from CAR_RENTAL_COMPANY_RENTAL_HISTORY
#                   where START_DATE >= '2022-08-01' and START_DATE <= '2022-10-31'
#                   group by CAR_ID
#                   having count(*) >= 5)
#     and START_DATE >= '2022-08-01' and START_DATE <= '2022-10-31'
# group by MONTH, CAR_ID
# order by MONTH asc, CAR_ID desc

# SELECT CAR_ID, MONTH(START_DATE) MONTH, COUNT(*) 
# FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
# WHERE START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
# GROUP BY CAR_ID, MONTH
# HAVING COUNT(*) >= 5

# select *, count(*) from CAR_RENTAL_COMPANY_RENTAL_HISTORY
# WHERE START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
# group by CAR_ID
# select * from CAR_RENTAL_COMPANY_RENTAL_HISTORY
# order by car_id