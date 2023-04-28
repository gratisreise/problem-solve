[LEVEL 1]
<과일로 만든 아이스크림 고르기>
SELECT a.FLAVOR
FROM FIRST_HALF a
LEFT JOIN  ICECREAM_INFO b
ON a.FLAVOR = b.FLAVOR
WHERE INGREDIENT_TYPE = "fruit_based" AND TOTAL_ORDER > 3000
ORDER BY TOTAL_ORDER DESC

<12세 이하인 여자 환자 목록 출력하기>
SELECT PT_NAME, GEND_CD, AGE, IFNULL(TLNO, 'NONE') AS TLNO
FROM PATIENT
WHERE AGE <= 12 AND GEND_CD = 'W'
ORDER BY AGE DESC, PT_NAME ASC

<흉부외과 또는 일반외과 의사 목록 출력하기>
SELECT DOCTORS.DOCTOR_NAME, DEPARTMENTS.DEPARTMENT_NAME
FROM DOCTORS
JOIN DEPARTMENTS ON DOCTORS.DEPARTMENT_ID = DEPARTMENTS.DEPARTMENT_ID
WHERE DEPARTMENTS.DEPARTMENT_NAME IN ('흉부외과', '일반외과')
ORDER BY DOCTORS.DOCTOR_ID;

<평균 일일 대여 요금 구하기>
SELECT AVG(DAILY_PRICE) AS AVERAGE_DAILY_PRICE
FROM RENTALS;

<인기있는 아이스크림>
SELECT NAME, PREFERENCE
SELECT FLAVOR
FROM FIRST_HALF
ORDER BY TOTAL_ORDER DESC, SHIPMENT_ID ASC

<조건에 맞는 도서 리스트 출력하기>
SELECT * 
FROM BOOKS
WHERE CATEGORY = 'IT' AND PRICE >= 20000
ORDER BY TITLE ASC;

<조건에 부합하는 중고거래 댓글 조회하기>
SELECT B.TITLE, B.BOARD_ID, R.REPLY_ID, R.WRITER_ID, R.CONTENTS, 
    DATE_FORMAT(R.CREATED_DATE, '%Y-%m-%d') AS CREATED_DATE 
FROM USED_GOODS_BOARD B
INNER JOIN USED_GOODS_REPLY R 
    ON B.BOARD_ID = R.BOARD_ID
WHERE DATE_FORMAT(B.CREATED_DATE, '%Y-%m') = '2022-10'
ORDER BY R.CREATED_DATE ASC, B.TITLE ASC;

<강원도에 위치한 생간공장 목록 출력하기>
SELECT *
FROM FACTORIES
WHERE REGION = '강원도' AND TYPE = '생간공장';

<모든 레코드 조회하기> //수정필요
SELECT *
FROM CUSTOMERS;

<역순 정렬하기>
SELECT *
FROM CUSTOMERS
ORDER BY NAME DESC;

<아픈 동물 찾기>
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION = 'Sick'

<어린 동물 찾기>
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION != 'Aged'
ORDER BY ANIMAL_ID

<동물의 아이디와 이름>
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
ORDER BY ANIMAL_ID

<여러 기준으로 정렬하기>
SELECT NAME, DATETIME
FROM ANIMAL_INS
ORDER BY NAME, DATETIME DESC

<상위 n개 레코드> 수정필요
SELECT ANIMAL_ID, NAME, DATETIME
FROM ANIMAL_INS
WHERE ANIMAL_ID NOT IN (SELECT ANIMAL_ID FROM ANIMAL_OUTS)
ORDER BY ANIMAL_ID
LIMIT n;

<조건에 맞는 회원수 구하기>
SELECT COUNT(*) AS count
FROM members
WHERE gender = 'M' AND age >= 30;


[LEVEL 2]
<3월에 태어난 여성 회원 목록 출력하기>
SELECT name
SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') AS DATE_OF_BIRTH
FROM MEMBER_PROFILE
WHERE TLNO IS NOT NULL 
AND GENDER = 'W' 
AND MONTH(DATE_OF_BIRTH) = 3
ORDER BY MEMBER_ID ASC;

<재구매가 일어난 상품과 회원 리스트 구하기>
SELECT o1.product_id, o1.buyer_id
FROM orders o1
JOIN orders o2
ON o1.product_id = o2.product_id AND o1.buyer_id = o2.buyer_id
WHERE o1.order_date < o2.order_date


[LEVEL 4]
<서울에 위치한 식당 목록 출력하기>
SELECT *
FROM restaurants
WHERE city = '서울';

<오프라인/온라인 판매 데이터 통합하기>
SELECT A.DAY, 
       COALESCE(SUM(A.NUM), 0) AS '일별 판매량',
       COALESCE(SUM(B.PRICE*A.NUM), 0) AS '일별 매출액'
FROM (
    SELECT DATE(O.ORDER_DATE) AS DAY, 
           P.PRODUCT_ID, 
           P.NAME, 
           O.AMOUNT AS NUM 
    FROM ORDERS O 
    JOIN PRODUCTS P ON O.PRODUCT_ID = P.PRODUCT_ID 
    WHERE O.SHOP_ID = 'S01' AND O.TYPE = 'ONLINE'
    UNION ALL
    SELECT DATE(S.SALES_DATE) AS DAY, 
           P.PRODUCT_ID, 
           P.NAME, 
           S.AMOUNT AS NUM 
    FROM SALES S 
    JOIN PRODUCTS P ON S.PRODUCT_ID = P.PRODUCT_ID 
    WHERE S.SHOP_ID = 'S01' AND S.TYPE = 'OFFLINE'
) A
LEFT JOIN (
    SELECT DATE(O.ORDER_DATE) AS DAY, 
           P.PRODUCT_ID, 
           P.PRICE 
    FROM ORDERS O 
    JOIN PRODUCTS P ON O.PRODUCT_ID = P.PRODUCT_ID 
    WHERE O.SHOP_ID = 'S01' AND O.TYPE = 'ONLINE'
    UNION ALL
    SELECT DATE(S.SALES_DATE) AS DAY, 
           P.PRODUCT_ID, 
           P.PRICE 
    FROM SALES S 
    JOIN PRODUCTS P ON S.PRODUCT_ID = P.PRODUCT_ID 
    WHERE S.SHOP_ID = 'S01' AND S.TYPE = 'OFFLINE'
) B ON A.DAY = B.DAY AND A.PRODUCT_ID = B.PRODUCT_ID
GROUP BY A.DAY
ORDER BY A.DAY;
