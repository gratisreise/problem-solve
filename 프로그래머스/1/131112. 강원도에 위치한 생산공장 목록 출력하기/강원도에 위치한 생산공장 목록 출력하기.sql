select factory_id, factory_name, address
from food_factory
where address like '강원도%'
order by factory_id asc
/*
강원도, 
공장id asc

공장id, 공장이름, 주소
*/