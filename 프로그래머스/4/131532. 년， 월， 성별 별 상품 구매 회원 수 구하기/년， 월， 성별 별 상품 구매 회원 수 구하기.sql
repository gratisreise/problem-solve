/*
- 
*/
# SELECT year(sales_date) year, month(sales_date) month, GENDER, COUNT(*)
# FROM USER_INFO U JOIN ONLINE_SALE O
# ON U.USER_ID = O.USER_ID
# GROUP BY year(sales_date), month(sales_date), GENDER
# order BY year, month, GENDER, O.USER_ID

select year(sales_date) YEAR ,month(sales_date) MONTH, GENDER, count(distinct(o.USER_ID)) USERS
from ONLINE_SALE o join USER_INFO u
on o.USER_ID = u.USER_ID
WHERE gender is not null
group by year(sales_date), month(sales_date), gender
ORDER BY YEAR, MONTH, GENDER
# select * from ONLINE_SALE
# order by sales_date, user_id