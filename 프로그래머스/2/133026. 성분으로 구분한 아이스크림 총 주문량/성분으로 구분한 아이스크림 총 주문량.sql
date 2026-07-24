select 
    i.ingredient_type,
    sum(total_order) as total_order
from first_half f
join icecream_info i
on f.flavor = i.flavor
group by i.ingredient_type
order by total_order



/*
상반기
성분타입별 총주문량
총주문량이 작은순


*/