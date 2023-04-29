[LEVEL 2]
<조건에 맞는 도서와 저자 리스트 출력하기>
SELECT B.TITLE, A.NAME
FROM AUTHOR A
JOIN BOOK B ON A.AUTHOR_ID = B.AUTHOR_ID
WHERE B.PUBLISH_YEAR >= 2015

select b.title, a.name 
from author A
join book b on a.author_id = b.author_id
<상품 별 오프라인 매출 구하기>
select p.product_code, sum(p.price * o.sales_amount) as sales
from product p
inner join offline_sale o on p.product_id = o.product_id
group by p.product_code
order by sales desc, p.product_code asc

[LEVEL 3]
<없어진 기록 찾기>
SELECT ANIMAL_OUTS.ANIMAL_ID, ANIMAL_OUTS.NAME
FROM ANIMAL_OUTS
LEFT JOIN ANIMAL_INS
ON ANIMAL_OUTS.ANIMAL_ID = ANIMAL_INS.ANIMAL_ID
WHERE ANIMAL_INS.ANIMAL_ID IS NULL
ORDER BY ANIMAL_OUTS.ANIMAL_ID;

<있었는데요 없었습니다>
select a.ANIMAL_ID, a.NAME
from ANIMAL_INS a
inner join ANIMAL_OUTS b on a.ANIMAL_ID = b.ANIMAL_ID
and a.DATETIME > b.DATETIME
order by a.DATETIME asc

<오랜 기간 보호한 동물(1)>
SELECT ANIMAL_ID, NAME
FROM ANIMAL_OUTS
WHERE DATETIME <= DATE_SUB(NOW(), INTERVAL 6 MONTH)
ORDER BY DATETIME ASC;

[LEVEL 4]
<특정 기간동안 대여 가능한 자동차들의 대여비용 구하기>
SELECT a.CAR_ID,a.CAR_TYPE,
ROUND(a.DAILY_FEE * 30 * (100 - b.DISCOUNT_RATE)/100) AS FEE
FROM CAR_RENTAL_COMPANY_CAR AS a
inner JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS b
    ON a.CAR_TYPE = b.CAR_TYPE AND b.DURATION_TYPE = '30일 이상'
WHERE a.CAR_TYPE IN ('세단', 'SUV')
AND a.CAR_ID NOT IN (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE END_DATE >= '2022-11-01' AND START_DATE <= '2022-11-30'
)
HAVING FEE >= 500000 AND FEE < 2000000
ORDER BY FEE DESC, a.CAR_TYPE ASC, a.CAR_ID DESC;

<5월 식품들의 총매출 조회하기>
SELECT SUM(price) AS total_sales
FROM sales
WHERE MONTH(sale_date) = 5
  AND category = '음식';

<주문량이 많은 아이스크림들 조회하기>
SELECT A.이름, A.가격, COUNT(*) as 판매량
FROM 아이스크림_메뉴 A JOIN 주문_상세 B
ON A.메뉴_ID = B.메뉴_ID
WHERE A.종류 = '아이스크림' AND B.주문_시간 BETWEEN '2022-04-01' AND '2022-04-30'
GROUP BY A.메뉴_ID
ORDER BY 판매량 DESC;

<그룹별 조건에 맞는 식당 목록 출력하기>
SELECT R.NAME, R.TYPE, R.PRICE
FROM RESTAURANTS R
JOIN MENU M ON R.ID = M.RESTAURANT_ID
WHERE M.NAME LIKE '%Pizza%' AND R.PRICE <= 15000
GROUP BY R.ID
HAVING COUNT(*) >= 2
ORDER BY R.NAME;

<보호소에서 중성화한 동물>
SELECT animal_id, animal_type, name, sex_upon_intake
FROM animal_ins
WHERE sex_upon_intake LIKE '%Intact%'
  AND (animal_type = 'Dog' OR animal_type = 'Cat')
ORDER BY animal_id;
<
SELECT YEAR(sale.SALES_DATE) AS year, 
        MONTH(sale.SALES_DATE) AS month, 
        COUNT(DISTINCT info.USER_ID) AS PUCHASED_USERS, 
        ROUND((COUNT(DISTINCT info.USER_ID) 
        / (SELECT count(user_id) FROM user_info WHERE YEAR(joined) = 2021)), 1) 
        AS PUCHASED_RATIO
FROM user_info AS info
INNER JOIN online_sale AS sale 
ON info.user_id = sale.user_id
WHERE YEAR(info.joined) = 2021
GROUP BY YEAR(sale.sales_date), MONTH(sale.sales_date)
ORDER BY YEAR(sale.sales_date), MONTH(sale.sales_date)