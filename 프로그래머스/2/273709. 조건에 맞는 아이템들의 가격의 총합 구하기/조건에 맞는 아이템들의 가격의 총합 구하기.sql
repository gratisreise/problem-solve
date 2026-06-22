select sum(price) as total_price
from item_info
where lower(rarity) = 'legend'


/*
희귀도 = 'legend'인 아이템 가격 총합
*/