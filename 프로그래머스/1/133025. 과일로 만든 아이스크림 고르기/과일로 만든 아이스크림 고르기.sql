select f.flavor
from first_half f
 join icecream_info i
 on f.flavor = i.flavor 
where total_order > 3000 and ingredient_type = 'fruit_based'
order by total_order desc 


/*
상반기, 아이스크림 총주문량 > 3000, 주성분 = 과일,
총주문량 내림차
*/