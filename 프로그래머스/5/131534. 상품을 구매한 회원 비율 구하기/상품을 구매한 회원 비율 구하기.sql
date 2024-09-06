/*
- 2021년에 가입한 회원들 중
- 상품을 구매한 회원수/ 가입한 전체 회원수, 소수점 둘째 반올림
- 년, 월 별로 출력
- 년 오름차, 월 오름차
1. 2021년에 가입한 회원의 정보를 뽑는 쿼리
2. 가입한 전체 회원수, 해당 
*/
# SELECT year(SALES_DATE) year, month(sales_date) month, count(a.user_id), 
#     YEAR (sales_date) YEAR, MONTH (sales_date) MONTH, ROUND(COUNT (DISTINCT a.user_id)/(
#     SELECT COUNT (*)
#     FROM USER_INFO
#     WHERE JOINED LIKE '2021%'
#     ), 2) PURCHASED_USERS
# FROM ONLINE_SALE a JOIN USER_INFO b
# ON a.USER_ID = b.USER_ID
# WHERE JOINED LIKE '2021%'
# GROUP BY YEAR, month


# 2021년에 가입한 사람 수
# (select count(*)
# from USER_INFO
# where JOINED like '2021%')

# select 
#     year(SALES_DATE) year,
#     month(SALES_DATE) month,
#     count(distinct a.USER_ID) PURCHASED_USERS,
#     round(count(distinct a.USER_ID)/(select count(distinct USER_ID) from USER_INFO where JOINED like '2021%'), 1) as PUCHASED_RATIO
# from ONLINE_SALE a join USER_INFO b on a.USER_ID = b.USER_ID
# group by year, month
# order by year, month


WITH TOTAL_USER AS (SELECT * FROM USER_INFO WHERE YEAR(JOINED) = 2021)



SELECT YEAR(OS.SALES_DATE) YEAR, MONTH(OS.SALES_DATE) MONTH, COUNT(DISTINCT UI.USER_ID) PURCHASED_USERS, ROUND(COUNT(DISTINCT UI.USER_ID) / (SELECT COUNT(*) FROM TOTAL_USER), 1) PUCHASED_RATIO
FROM USER_INFO UI
JOIN ONLINE_SALE OS
ON UI.USER_ID = OS.USER_ID

WHERE YEAR(UI.JOINED) = 2021
GROUP BY 1, 2
ORDER BY 1, 2
