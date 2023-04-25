[LEVEL 1]
<자동차 대여 기록에서 장기/단기 대여 구분하기>
SELECT
  rent_id,
  car_id,
  CASE
    WHEN return_date - rent_date >= 28 THEN 'long'
    ELSE 'short'
  END AS rental_type
FROM
  rentals
ORDER BY rent_id;

<특정 옵션이 포함된 자동차 리스트 구하기>
SELECT car_id, car_name, option_name
FROM car_options
WHERE option_name IN ('네비게이션', '블랙박스')
GROUP BY car_id, car_name
HAVING COUNT(DISTINCT option_name) = 2;

[LEVEL 2]
<자동차 평균 대여 기간 구하기>
SELECT AVG(DATEDIFF(return_date, rent_date)) AS '평균 대여 기간'
FROM rent

<조건에 부합하는 중고거래 상태 조회하기>
SELECT 
    ID, 
    IF(PROFIT > 0, 'profit', IF(PROFIT = 0, 'no loss', 'loss')) AS 'PROFIT STATE'
FROM (
    SELECT 
        ID, 
        (PRICE * COUNT) - (PRICE * COUNT * 0.1 + FEE) AS PROFIT
    FROM 
        TRANSACTIONS
    WHERE 
        PRICE >= 5000 AND (CITY = 'SEOUL' OR CITY = 'BUSAN') AND (YEAR(DATE) = 2022) 
) T;

<루시와 엘라 찾기>
SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
WHERE NAME IN ('Lucy', 'Ella', 'Lucky', 'Sunny', 'Ralph', 'Rooney')
ORDER BY ANIMAL_ID;

<이름에 el이 들어가는 동물 찾기>
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE NAME LIKE '%el%' AND ANIMAL_TYPE = 'Dog'
ORDER BY NAME;

<중성화 여부 파악하기>
SELECT ANIMAL_ID, NAME, 
       CASE WHEN SEX_UPON_INTAKE LIKE 'Neutered%' OR SEX_UPON_INTAKE LIKE 'Spayed%' THEN 'O' 
            ELSE 'X' END AS '중성화'
FROM ANIMAL_INS;

<DTAETIME에서 DATE로 형 변환>
SELECT ANIMAL_ID, NAME, DATE_FORMAT(DATETIME, '%Y-%m-%d') AS 날짜
FROM ANIMAL_INS;

<카테고리별 상품 개수 구하기>
SELECT C.CATEGORY_NAME, COUNT(P.PRODUCT_ID) AS PRODUCT_COUNT
FROM CATEGORIES C
JOIN PRODUCTS P ON C.CATEGORY_ID = P.CATEGORY_ID
GROUP BY C.CATEGORY_NAME
ORDER BY C.CATEGORY_NAME;

[LEVEL 3]
<조건에 맞는 사용자 정보 조회하기>
SELECT *
FROM USER
WHERE POINT >= 1000 AND (AGE >= 25 OR GENDER = 'F')
ORDER BY NAME ASC;

<조회수가 가장 많은 중고거래 게시판의 첨부파일 조회하기>
SELECT file_name
FROM posts
WHERE board_type = '중고거래'
ORDER BY views DESC
LIMIT 1;

<조건별로 분류하여 주문상태 출력하기>
SELECT 
    COUNT(CASE WHEN o.order_status = 'paid' THEN 1 END) as paid,
    COUNT(CASE WHEN o.order_status = 'cancelled' THEN 1 END) as cancelled,
    COUNT(CASE WHEN o.order_status = 'confirmed' THEN 1 END) as confirmed
FROM orders o

<대여 기록이 존재하는 자동차 리스트 구하기>
SELECT DISTINCT car_id
FROM rentals

<오랜 기간 보호한 동물(2)>
SELECT I.ANIMAL_ID, I.NAME
FROM ANIMAL_INS I
LEFT JOIN ANIMAL_OUTS O ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE O.ANIMAL_ID IS NULL
AND I.DATETIME < DATE_SUB(NOW(), INTERVAL 60 DAY)
ORDER BY I.DATETIME ASC;


[LEVEL 4]
<자동차 대여 기록 별 대여 금액 구하기>
SELECT rent_id, car_id, CONCAT('$', FORMAT(rent_hours * rate, 2)) AS rental_fee
FROM RentRecords

<취소되지 않은 진료 예약 조회하기>
SELECT A.reserve_date, A.reserve_time, A.patient_id, B.patient_name, A.department, A.doctor
FROM reservation A
INNER JOIN patient B ON A.patient_id = B.patient_id
WHERE A.status = 'ACTIVE'
ORDER BY A.reserve_date, A.reserve_time;
