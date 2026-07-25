select 
    food_type, rest_id, rest_name, favorites 
from rest_info r
where favorites = (
    select max(favorites)
    from rest_info
    where r.food_type = food_type
) 
group by food_type
order by food_type desc 

/*
음식종류별,
즐찾수 max 
음식조율 내림차 

*/