# 년, 월, 성별 별 상품 구매한 회원수

select 
    year(sales_date) as year,
    month(sales_date) as month,
    u.gender,
    count(distinct u.user_id) as users
from online_sale o join user_info u
on o.user_id = u.user_id and u.gender is not null
group by year(sales_date), month(sales_date), u.gender