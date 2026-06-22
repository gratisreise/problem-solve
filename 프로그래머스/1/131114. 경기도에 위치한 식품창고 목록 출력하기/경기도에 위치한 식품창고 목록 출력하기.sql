select warehouse_id, warehouse_name, address, ifnull(freezer_yn, 'N') as freezer_yn
from food_warehouse
where address like '경기도%'
order by warehouse_id



/*
경기도, 
여부 == NULL => 'N' 출력
오름차순 정렬

창고의id, 이름, 주소, 냉동시설 여부

*/