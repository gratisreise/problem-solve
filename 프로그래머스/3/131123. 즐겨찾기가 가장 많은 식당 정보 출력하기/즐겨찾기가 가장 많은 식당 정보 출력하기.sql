# 음식종류별, 즐찻max 음식점, 종류 내림차
with maxs as (
    select 
        *,
        max(favorites) over(partition by food_type order by favorites desc)as max_favorites
    from rest_info
)

select food_type, rest_id, rest_name, favorites
from maxs
where favorites = max_favorites
order by food_type desc