with processed_data as (
    select floor(price/10000) * 10000 as price_group 
    from product
)
select price_group, count(*) as products
from processed_data
group by price_group
order by price_group 


/*
가격대 별, 상품갯수, 
가격대 오름차
*/