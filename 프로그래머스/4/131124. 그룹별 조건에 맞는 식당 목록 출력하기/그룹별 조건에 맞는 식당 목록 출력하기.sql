/*
- 리뷰 max 회원
- 회원 이름, 리뷰 텍스트, 리뷰 작성일
- 리뷰 작성일 오름차, 리뷰 텍스트 오름차
1. 가장 많은 댓글 수를 구하는 서브쿼리 작성
2. 그 댓글 수와 같은 수의 멤버 아이디 구하기
3. 해당 멤버 아이디와 같은 멤버아이디의 리뷰글을 구하기
4. REVIEW_DATE asc, MEMBER_PROFILE asc
*/

SELECT c.member_name
     , a.review_text
     , date_format(a.review_date, '%Y-%m-%d')
FROM rest_review a
         INNER JOIN (SELECT member_id
                     FROM rest_review
                     GROUP BY member_id
                     ORDER BY COUNT(*) DESC LIMIT 1) b
                    ON a.member_id = b.member_id
         LEFT JOIN member_profile c ON a.member_id = c.member_id
ORDER BY a.review_date, a.review_text