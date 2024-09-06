/*
- 자동차 종류 = 세단, suv
- 2022년 11월에 대여가능
- 30일 대여금액 50만원이상 200만원 미만
- 자동차 ID, 자동차 종류, 대여 금액(FEE)
- 대여금액 내림차, 종류 오름차. id 내림차 정렬
1. 해당기간에 대여 가능한 차 id 구하는 서브쿼리 조인 자동차 테이블
2. 대여금액 
*/
SELECT a.car_id,
       a.car_type,
       round((daily_fee * 30 * (100 - CAST(replace(discount_rate, '%', '') AS unsigned))) / 100,
             0) AS fee
FROM car_rental_company_car a
         JOIN (SELECT car_id,
                      COUNT(
                              CASE
                                  WHEN start_date > '2022-11-30' OR end_date < '2022-11-01'
                                      THEN NULL
                                  ELSE 1
                                  END) AS temp
               FROM car_rental_company_rental_history
               GROUP BY car_id
               HAVING temp = 0) b ON a.car_id = b.car_id
         JOIN (SELECT *
               FROM car_rental_company_discount_plan
               WHERE duration_type LIKE '30%') c ON a.car_type = c.car_type
having 500000 <= FEE AND  FEE <= 2000000
ORDER BY 3 DESC, 2, 1 DESC


