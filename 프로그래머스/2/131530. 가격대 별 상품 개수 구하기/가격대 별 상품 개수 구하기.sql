# 만원 단위의 가격대 별, 상품 개수
with cte1 as (
    select 
        *,
        floor(price / 10000) * 10000 as price_group
    from product
)

select 
    price_group,
    count(*) as proudcts
from cte1
group by price_group 
order by price_group asc