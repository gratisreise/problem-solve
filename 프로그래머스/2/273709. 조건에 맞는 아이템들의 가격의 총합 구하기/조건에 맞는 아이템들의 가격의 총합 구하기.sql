-- legend 아이템 가격 초합
select sum(price) as total_price
from item_info
where rarity = 'LEGEND'
group by rarity