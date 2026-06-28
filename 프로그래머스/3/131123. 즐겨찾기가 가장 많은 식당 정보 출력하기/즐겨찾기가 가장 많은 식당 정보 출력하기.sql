select food_type, rest_id, rest_name, favorites
from rest_info r1
where favorites = (
     select max(favorites)
     from rest_info
     where food_type = r1.food_type
)
group by food_type
order by food_type desc



/*
음식종류별, 즐찾수 가장많은 식당
음식 종류, id, 식당이름, 즐찾수
음식종류 내림차

*/