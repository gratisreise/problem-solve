-- 년, 월, 성별 별
-- 회원수
-- 년, 월, 성별 오름차
-- 성별 null은 제외

select 
    year(SALES_DATE) as YEAR, 
    month(SALES_DATE) as MONTH, 
    i.GENDER as GENDER,
    count(distinct(i.user_id)) as USERS
from USER_INFO i
join ONLINE_SALE o on i.USER_ID = o.USER_ID
where gender is not null
group by year(SALES_DATE), month(SALES_DATE), i.GENDER
order by 1, 2, 3