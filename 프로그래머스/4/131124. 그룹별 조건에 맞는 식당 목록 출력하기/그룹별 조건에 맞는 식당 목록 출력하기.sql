-- 리뷰 가장 많이 작성
-- 리뷰 작성일 오름차, 텍스트 오름차
select p.MEMBER_NAME, r.REVIEW_TEXT, 
    date_format(r.REVIEW_DATE, '%Y-%m-%d') as REVIEW_DATE
from MEMBER_PROFILE p
join REST_REVIEW r on p.MEMBER_ID = r.MEMBER_ID
where  p.member_id = (
    select member_id 
    from REST_REVIEW
    group by MEMBER_ID
    order by count(*) desc
    limit 1) 
order by r.REVIEW_DATE, r.REVIEW_TEXT



-- 그룹핑 -> 갯수세주고 -> max 뽑아내기 -> 어떻게 이어주지?
