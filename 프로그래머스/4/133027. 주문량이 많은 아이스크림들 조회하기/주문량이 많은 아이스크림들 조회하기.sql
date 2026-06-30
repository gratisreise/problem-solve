with total as(
    select flavor, total_order 
    from first_half
    
    union all
    
    select flavor, total_order
    from july
)

select flavor
from total
group by flavor
order by sum(total_order) desc
limit 3