select i.rest_id, i.rest_name, i.food_type, i.favorites, i.address, 
    round(avg(review_score), 2) as score
from rest_info as i 
  join rest_review as r
     on i.rest_id = r.rest_id
where  i.address like '서울%'
group by r.rest_id
order by score desc, i.favorites desc




/*
info, review
서울, 
평균점수 내림차, 즐찾 내림차 

식당id, 식당이름, 음식종류, 즐겨찾기수, 주소, 리뷰 평균점수(0.2f)


*/