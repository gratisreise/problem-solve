select 
    ri.rest_id, 
    ri.rest_name, 
    ri.food_type,
    ri.favorites,
    ri.address,
    round(avg(rr.review_score), 2) as score
from rest_info as ri
join rest_review as rr on ri.rest_id = rr.rest_id
where address like '서울%'
group by ri.rest_id
order by score desc, ri.favorites desc



/*
식당id, 식당이름, 음식종류, 즐겨찾기수, 주소, 리뷰 평균 점수
rest_info, rest_review
위치=서울, 리뷰평균점수 소수점 3번째 반올림, 
평균점수 내림차, 즐겨찾기수 내림차

*/