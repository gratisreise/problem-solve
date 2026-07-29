select
    i.rest_id,
    i.rest_name,
    i.food_type,
    i.favorites,
    i.address,
    round(avg(review_score), 2) as score
from rest_info i
join rest_review r
on i.rest_id = r.rest_id 
where address like '서울%'
group by i.rest_id 
order by score desc, i.favorites desc



/*
서울위치 식당, 
평균점수 세번째 반올림, 
평균점수 내림차,  즐찾 내림차


*/