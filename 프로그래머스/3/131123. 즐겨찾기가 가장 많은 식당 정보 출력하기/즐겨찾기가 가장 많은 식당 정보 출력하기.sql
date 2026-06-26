select food_type, rest_id, rest_name, favorites
from rest_info r1
where favorites = (
    select max(favorites)
    from rest_info
    where r1.food_type = food_type
)
order by food_type desc 


/*
음식종류별
즐겨찾기수 가장많은, 
음식종류 내림차

음식종류, id, 식당이름, 즐겨찾기수


*/