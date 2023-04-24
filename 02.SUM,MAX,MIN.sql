[LEVEL 1]
<가장 비싼 상품 구하기>
SELECT PRODUCT_NAME
FROM PRODUCT
WHERE PRICE = (SELECT MAX(PRICE) FROM PRODUCT);

<최댓값 구하기>
SELECT MAX(column_name) FROM table_name;

[LEVEL 2]
<가격이 제일 비싼 식품의 정보 출력하기>
SELECT *
FROM food
WHERE price = (SELECT MAX(price) FROM food);

<최솟값 구하기>
SELECT MIN(datetime) AS '가장 일찍 입양된 날짜'
FROM animal_ins;

<동물 수 구하기>
SELECT COUNT(*) AS count FROM ANIMAL_INS;

<중복 제거하기>
SELECT COUNT(DISTINCT NAME) AS COUNT
FROM ANIMAL_INS

