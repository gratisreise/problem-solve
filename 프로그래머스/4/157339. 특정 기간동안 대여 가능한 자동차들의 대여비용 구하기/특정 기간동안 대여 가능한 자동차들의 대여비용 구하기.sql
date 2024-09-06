/*
- 자동차 종류 = 세단, suv
- 2022년 11월에 대여가능
- 30일 대여금액 50만원이상 200만원 미만
- 자동차 ID, 자동차 종류, 대여 금액(FEE)
- 대여금액 내림차, 종류 오름차. id 내림차 정렬
1. 해당기간에 대여 가능한 차 id 구하는 서브쿼리 조인 자동차 테이블
2. 대여금액 
*/
SELECT
        a.CAR_ID, a.CAR_TYPE,
        ROUND((daily_fee * 30 * (100 -CAST(REPLACE(discount_rate, '%', '') AS UNSIGNED))) / 100, 0) as FEE
FROM car_rental_company_car a
         JOIN (SELECT car_id,
                      COUNT(
                              CASE
                                  WHEN start_date > '2022-11-30' OR end_date < '2022-11-01' THEN NUll
                                  ELSE 1
                                  END) AS temp
               FROM car_rental_company_rental_history
               GROUP BY car_id
               HAVING temp = 0) b ON a.car_id = b.car_id
        join  (
            select *
            from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
            where DURATION_TYPE like '30%'
            ) c on a.car_type = c.car_type
where 500000 <= ROUND((daily_fee * 30 * (100 -CAST(REPLACE(discount_rate, '%', '') AS UNSIGNED))) / 100, 0) 
and ROUND((daily_fee * 30 * (100 -CAST(REPLACE(discount_rate, '%', '') AS UNSIGNED))) / 100, 0) <= 2000000
order by 3 desc, 2, 1 desc
# select * from CAR_RENTAL_COMPANY_CAR
# select * from CAR_RENTAL_COMPANY_RENTAL_HISTORY
        