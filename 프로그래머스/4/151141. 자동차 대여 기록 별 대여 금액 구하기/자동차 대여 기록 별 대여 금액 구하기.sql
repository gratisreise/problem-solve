/*
- 종류 트럭
- 대여 기록 별 대여 금액, 대여 기록 ID, 대여 금액
- 대여 금액 내림차
*/

# (SELECT *,
#     CASE
#         WHEN DATEDIFF(END_DATE, START_DATE) + 1 < 30  THEN '7일 이상'
#         WHEN DATEDIFF(END_DATE, START_DATE) + 1 < 90  THEN '30일 이상'
#         else '90일 이상'
#     END as days1,
# from CAR_RENTAL_COMPANY_RENTAL_HISTORY)

# (select * 
# from CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
# where car_type = '트럭')


select 
    history_id,
    round(daily_fee * (DATEDIFF(END_DATE, START_DATE) + 1) * (100 - IFNULL(DISCOUNT_RATE, 0))/ 100, 0) FEE
from 
    (
        select 
            *,
            CASE
                WHEN DATEDIFF(END_DATE, START_DATE) + 1 < 7  then  null
                WHEN DATEDIFF(END_DATE, START_DATE) + 1 < 30  THEN '7일 이상'
                WHEN DATEDIFF(END_DATE, START_DATE) + 1 < 90  THEN '30일 이상'
                else '90일 이상'
            END DURATION_TYPE
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    ) a join CAR_RENTAL_COMPANY_CAR b
        on a.CAR_ID = b.CAR_ID
        left join CAR_RENTAL_COMPANY_DISCOUNT_PLAN c
        on c.car_type = b.car_type and a.DURATION_TYPE = c.DURATION_TYPE
where b.CAR_TYPE = '트럭'
order by 2 desc, 1 desc