# 서울 위치,리뷰평균점수(.2f) 내림차순, 즐겨찾기수 내림차 

select 
    i.rest_id,
    i.rest_name, 
    i.food_type,
    i.favorites,
    i.address,
    round(avg(r.review_score), 2) as score
from rest_info i join rest_review r
on i.rest_id = r.rest_id 
where i.address like '서울%'
group by i.rest_id 
order by avg(r.review_score) desc, i.favorites desc