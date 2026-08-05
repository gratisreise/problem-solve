select
    year(sales_date) year,
    month(sales_date) as month,
    count(distinct(o.user_id)) as purchased_users,
    round(count(distinct(o.user_id)) / (select count(*) from user_info where year(joined) = 2021), 1) as purchased_ratio
from user_info u
join online_sale o
on u.user_id = o.user_id
where year(u.joined) = 2021
group by year(o.sales_date), month(o.sales_date)
order by year asc, month asc



/*
상품을 구매한 회원의 비율
년, 월별, 

상품을 구매한 회원수, 상품을 구매한 회원의 비율

조인해서 그룹화 해서 년, 월, 그룹화 해서 구입 여부 
*/