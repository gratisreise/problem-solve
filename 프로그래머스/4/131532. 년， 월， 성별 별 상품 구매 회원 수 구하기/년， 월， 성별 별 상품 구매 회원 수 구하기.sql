select 
    year(sales_date) as year,
    month(sales_date) as month,
    gender,
    count(distinct(u.user_id)) as users
from user_info u
 join online_sale o
  on u.user_id = o.user_id
where gender is not null
group by year, month, gender
order by year, month, gender


/*
년, 월, 성별 별 상품 구매 회원수
년, 월, 성별 오름차
성별정보 없는 경우 제외


*/