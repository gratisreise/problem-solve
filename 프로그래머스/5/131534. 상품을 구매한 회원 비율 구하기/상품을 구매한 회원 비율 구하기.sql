select year(sales_date) as year, month(sales_date) as month,
    count(distinct(o.user_id)) as purchased_users,
    round(
        count(distinct(o.user_id)) / (
        select count(*) from user_info
        where year(joined) = 2021
    ), 1
    ) as purchased_ratio
from online_sale o
join user_info u
on o.user_id = u.user_id
where year(u.joined) = 2021
group by year(sales_date), month(sales_date)


/*
2021년에 가입한 회원 중 
상품을 구매한 회원수,
년,월별, 
상품구매회원비율(소수둘째반올림), 
년 오름차, 월 오름차

*/