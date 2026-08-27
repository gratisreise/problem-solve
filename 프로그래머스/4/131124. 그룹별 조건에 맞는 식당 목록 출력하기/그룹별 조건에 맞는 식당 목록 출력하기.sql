# 리뷰를 max 작성 
# 리뷰작성일 오름차, 리뷰텍스트 오름차 
with max_id as (
    select member_id from rest_review
    group by member_id 
    order by count(*) desc
    limit 1
)

select mp.member_name, rr.review_text, rr.review_date
from member_profile mp join rest_review rr 
on mp.member_id = rr.member_id 
where mp.member_id = (select member_id from max_id)
order by rr.review_date asc, rr.review_text asc 