select f.flavor
from first_half as f
join icecream_info as i
    on f.flavor = i.flavor
where i.ingredient_type = 'fruit_based' and f.total_order > 3000
order by total_order desc


/*
상반기
총주문량 > 3000, 주성분=과일, 총주문량 내림차

맛
*/