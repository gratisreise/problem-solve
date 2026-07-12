select year(sales_date) as year,
    month(sales_date) as month,
    count(distinct(o.user_id)) as purchased_users,
    round(count(distinct(o.user_id)) 
          / (select count(*) from user_info where year(joined) =2021), 1)
    as purchased_ratio
from user_info u
join online_sale o
on u.user_id = o.user_id and year(u.joined) = 2021
group by year(sales_date), month(sales_date)
order by year, month

/*
2021년에 가입
상품 구매한 회원수, 상품구매한 회원 비율(가입+구매/가입) => 소수 두번째 반올림,
년,월별 
년 오름차, 월 오름차

2021년에 가입 수

*/