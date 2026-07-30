select 
    year(sales_date) as year, 
    month(sales_date) as month, 
    u.gender, 
    count(distinct(o.user_id)) as users
from user_info u
join online_sale o
on u.user_id = o.user_id 
where u.gender is not null
group by year(sales_date), month(sales_date), u.gender
order by year asc, month asc, u.gender asc

/*
년, 월, 성별 별로 상품을 구매한 회원수
년, 월, 성별, 오름차
성별정보 없으면 제외

*/