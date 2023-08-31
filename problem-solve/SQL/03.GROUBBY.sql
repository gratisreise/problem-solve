[LEVEL 2]
<자동차 종류 별 특정 옵션이 포함된 자동차 수 구하기>
SELECT car_type, COUNT(DISTINCT car_id) AS cnt
FROM car_option
GROUP BY car_type
HAVING SUM(option_name = 'ABS') > 0;

<성분으로 구분한 아이스크림 총 주문량>
select b.INGREDIENT_TYPE, sum(a.TOTAL_ORDER) as TOTAL_ORDER
from FIRST_HALF a
inner join ICECREAM_INFO b
on a.FLAVOR = b.FLAVOR
group by b.INGREDIENT_TYPE
order by TOTAL_ORDER

<진료과별 총 예약 횟수 출력하기>
SELECT department, COUNT(*) AS reservation_count
FROM hospital
GROUP BY department;

<동명 동물 수 찾기>
SELECT NAME, COUNT(*) AS COUNT
FROM ANIMAL_INS
WHERE NAME IN (
    SELECT NAME
    FROM ANIMAL_INS
    GROUP BY NAME
    HAVING COUNT(*) > 1
)
GROUP BY NAME
ORDER BY NAME;

<입양 시각 구하기(1)>
select hour(DATETIME) as HOUR, count(ANIMAL_ID) as COUNT
from ANIMAL_OUTS
where hour(DATETIME) between 9 and 19
group by HOUR
order by HOUR

<가격대 별 상품 개수 구하기>
SELECT 
  CASE 
    WHEN PRICE BETWEEN 0 AND 999 THEN '0-999' 
    WHEN PRICE BETWEEN 1000 AND 1999 THEN '1000-1999' 
    WHEN PRICE BETWEEN 2000 AND 2999 THEN '2000-2999' 
    ELSE '3000 이상' 
  END AS PRICE_RANGE, 
  COUNT(*) AS PRODUCT_COUNT 
FROM PRODUCTS 
GROUP BY PRICE_RANGE;


[LEVEL 3]
<즐겨찾기가 가장 많은 식당 정보 출력하기>
SELECT r.restaurant_id, r.restaurant_name, COUNT(*) AS favorite_count
FROM restaurants r
JOIN favorites f ON r.restaurant_id = f.restaurant_id
GROUP BY r.restaurant_id, r.restaurant_name
ORDER BY favorite_count DESC
LIMIT 1;

<자동차 대여 기록에서 대여중 / 대여 가능 여부 구분하기>
SELECT CAR_ID,
  CASE 
    WHEN END_DATE IS NULL THEN 'IN-USE'
    ELSE 'AVAILABLE'
  END AS RENTAL_STATUS
FROM RENTAL_RECORDS
ORDER BY CAR_ID;

<카테고리 별 도서 판매량 집계하기>
SELECT c.name AS category_name, 
       IFNULL(SUM(s.quantity), 0) AS total_sales
FROM categories c 
LEFT JOIN products p ON c.id = p.category_id 
LEFT JOIN order_items s ON p.id = s.product_id 
GROUP BY c.name;

<조건에 맞는 사용자와 총 거래금액 조회하기>
SELECT u.user_id, u.name, SUM(o.price)
FROM users u
JOIN orders o ON u.user_id = o.user_id
WHERE o.created_at BETWEEN '2022-01-01' AND '2022-12-31'
GROUP BY u.user_id
HAVING SUM(o.price) >= 100000

<대여 횟수가 많은 자동차들의 월별 대여 횟수 구하기>
SELECT DATE_FORMAT(start_date, '%Y-%m') AS month,
       car_id,
       COUNT(*) AS rental_count
FROM rentals
GROUP BY month, car_id
HAVING rental_count >= 5
ORDER BY month ASC, rental_count DESC

[LEVEL 4]
<식품분류별 가장 비싼 식품의 정보 조회하기>
select a.CATEGORY,
       max(a.PRICE) as MAX_PRICE,
       (select PRODUCT_NAME 
        from FOOD_PRODUCT 
        where CATEGORY = a.CATEGORY 
        order by PRICE desc limit 1) as PRODUCT_NAME
from FOOD_PRODUCT a
where CATEGORY in ('과자', '국', '김치', '식용유')
group by CATEGORY
order by MAX_PRICE desc

<저자 별 카테고리 별 매출액 집계하기>
SELECT CATEGORY,sum(SALES) as TOTAL_SALES
from BOOK as b
join BOOK_SALES as bs 
on b.BOOK_ID = bs.BOOK_ID
where year(SALES_DATE) = '2022' and month(sales_date)= "01"
group by CATEGORY
order by CATEGORY

<년, 월, 성별 별 상품 구매 회원 수 구하기>
SELECT YEAR(order_date) AS '년도', MONTH(order_date) AS '월', gender AS '성별', COUNT(DISTINCT user_id) AS '구매 회원 수'
FROM orders
JOIN users ON orders.user_id = users.user_id
GROUP BY YEAR(order_date), MONTH(order_date), gender
ORDER BY YEAR(order_date), MONTH(order_date), gender;

<입양 시각 구하기(2)>
SELECT hour, 
       COUNT(*) count
FROM (
    SELECT DATE_FORMAT(datetime, '%H') hour
    FROM animal_outs
    WHERE datetime BETWEEN '2019-01-01 00:00:00' AND '2019-12-31 23:59:59'
) a
GROUP BY hour
ORDER BY hour ASC;
