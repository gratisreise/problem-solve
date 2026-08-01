select m.member_name, r.review_text, r.review_date
from member_profile m
join rest_review r
on m.member_id = r.member_id 
where m.member_id = (
    select member_id
    from rest_review
    group by member_id
    order by count(*) desc
    limit 1
)
order by r.review_date asc, r.review_text asc



/*
리뷰 가장 많이 작성한 회원의 리뷰

회원일므, 리뷰 텍스트, 리뷰 작성일 
리뷰 작성일 오름차, 리뷰 텍스트 오름차

*/