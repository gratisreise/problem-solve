[LEVEL 2]
<자동차 종류 별 특정 옵션이 포함된 자동차 수 구하기>
SELECT car_type, COUNT(DISTINCT car_id) AS cnt
FROM car_option
GROUP BY car_type
HAVING SUM(option_name = 'ABS') > 0;

<성분으로 구분한 아이스크림 총 주문량>
SELECT A.ingredient, SUM(B.amount) as total_amount
FROM products A 
JOIN sales B ON A.product_id = B.product_id
GROUP BY A.ingredient;

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
SELECT HOUR(datetime) AS HOUR, COUNT(*) AS COUNT
FROM ANIMAL_OUTS
WHERE DATE(datetime) = '2019-01-01'
GROUP BY HOUR
ORDER BY HOUR;

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
SELECT F.FOOD_CLASS, F.FOOD_NAME, F.PRICE
FROM FOODS F
JOIN (
    SELECT FOOD_CLASS, MAX(PRICE) AS MAX_PRICE
    FROM FOODS
    GROUP BY FOOD_CLASS
) MAX_F
ON F.FOOD_CLASS = MAX_F.FOOD_CLASS AND F.PRICE = MAX_F.MAX_PRICE
ORDER BY F.FOOD_CLASS

<저자 별 카테고리 별 매출액 집계하기>
SELECT a.author_name, b.category, SUM(b.amount) as sales
FROM authors a
INNER JOIN books b ON a.author_id = b.author_id
INNER JOIN orders o ON b.book_id = o.book_id
GROUP BY a.author_name, b.category
ORDER BY sales DESC

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
