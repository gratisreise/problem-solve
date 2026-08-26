# 7월, 상반기 총주문량, 총주문량


with cte1 as(select shipment_id, flavor, total_order 
from first_half

union all

select shipment_id, flavor, total_order
from july)

select flavor
from cte1
group by flavor
order by sum(total_order) desc
limit 3