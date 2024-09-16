/*
- 식품별 gb
- 제일 비싼 식품 MAX
- 식품의 분류, 가격, 이름
- 식품 분류 = 과자, 국, 김치, 식용유
- 식품 가격 desc
[1번째: 서브쿼리]
1. 식품별로 그룹핑
2. max 가격 뽑기
3. 서브쿼리로 컬럼 설정
4. 식품분류 조건
[2번째: 조인]
1. 식품별로 그룸핑 테이블 설정
2. id로 join
3. max가격 같은조건
4. 식품 분류조건
*/
# SELECT P.CATEGORY, MAX(PRICE) AS MAX_PRICE,
#     (SELECT PRODUCT_NAME
#     FROM FOOD_PRODUCT
#     WHERE CATEGORY = P.CATEGORY
#     ORDER BY PRICE DESC
#     LIMIT 1) AS PRODUCT_NAME
# FROM FOOD_PRODUCT P
# WHERE CATEGORY IN('과자', '국', '김치', '식용유')
# GROUP BY CATEGORY
# ORDER BY MAX_PRICE DESC

SELECT F2.CATEGORY, MAX_PRICE, PRODUCT_NAME
FROM FOOD_PRODUCT F1 JOIN (
    SELECT CATEGORY, MAX(PRICE) AS MAX_PRICE
    FROM FOOD_PRODUCT
    GROUP BY CATEGORY) AS F2
ON F1.CATEGORY = F2.CATEGORY
WHERE F1.PRICE = MAX_PRICE 
AND F2.CATEGORY IN('과자', '국', '김치', '식용유')
ORDER BY MAX_PRICE DESC