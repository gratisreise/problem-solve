select i.rest_id, i.rest_name, i.food_type, i.favorites, i.address, 
round(avg(review_score), 2) as score
from rest_info i 
 join rest_review r
  on i.rest_id = r.rest_id
where address like '서울%'
group by i.rest_id 
order by score desc, i.favorites desc 
 


/*
식당id, 식당이름, 음식종류, 즐겨찾기수, 주소, 리뷰평균점수(.2f, )
서울 위치,
평균점수 내림차, 즐찾 내림차
*/