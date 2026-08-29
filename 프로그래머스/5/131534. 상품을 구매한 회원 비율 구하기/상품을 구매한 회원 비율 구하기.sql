# 2021년, 년,월 별 .1f, 년 오름차, 월 오름차
# 2021년 
with cte1 as ( # 2021년 가입한 놈과 그때 가입한 회원의 수 
    select 
        *,
        count(*) over(partition by year(joined)) as totals
    from user_info
    where year(joined) = 2021
)

select 
    year(sales_date) as year,
    month(sales_date) as month,
    count(distinct os.user_id) as purchased_users,
    round((count(distinct os.user_id) / totals), 1) as purchased_ratio
from online_sale os join cte1 c1
on os.user_id = c1.user_id
group by year(sales_date), month(sales_date)
order by year asc, month asc