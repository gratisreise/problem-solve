-- 음식종류별
-- 즐찾 수 가장 많은 식당
-- 음식종류, id, 식당이름, 즐찾수
-- 음식종류 내림차
select food_type, rest_id, rest_name, favorites
from rest_info
where (food_type, favorites) 
    in (select food_type, max(favorites)
       from rest_info group by food_type)
order by food_type desc;
