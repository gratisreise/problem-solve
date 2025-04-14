/*
- 종류 트럭
- 대여 기록 별 대여 금액, 대여 기록 ID, 대여 금액
- 대여 금액 내림차
*/
SELECT history_id,
       round(daily_fee * (datediff(end_date, start_date) + 1) * (100 - ifnull(discount_rate, 0)) /
             100, 0) fee
FROM (SELECT *,
             CASE
                 WHEN datediff(end_date, start_date) + 1 < 7 THEN NULL
                 WHEN datediff(end_date, start_date) + 1 < 30 THEN '7일 이상'
                 WHEN datediff(end_date, start_date) + 1 < 90 THEN '30일 이상'
                 ELSE '90일 이상'
                 END duration_type
      FROM car_rental_company_rental_history) a
         JOIN car_rental_company_car b
              ON a.car_id = b.car_id
         LEFT JOIN car_rental_company_discount_plan c
                   ON c.car_type = b.car_type AND a.duration_type = c.duration_type
WHERE b.car_type = '트럭'
ORDER BY 2 DESC, 1 DESC