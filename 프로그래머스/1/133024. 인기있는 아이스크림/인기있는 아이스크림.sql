# 상반기, 총주문량 내림차, 출하번호 오름차 

select flavor 
from first_Half
order by total_order desc, shipment_id asc