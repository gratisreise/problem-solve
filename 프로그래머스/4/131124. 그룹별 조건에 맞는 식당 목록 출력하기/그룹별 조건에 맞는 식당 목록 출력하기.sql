/*
- 리뷰 max 회원
- 회원 이름, 리뷰 텍스트, 리뷰 작성일
- 리뷰 작성일 오름차, 리뷰 텍스트 오름차
1. 최가 게시글 회원 서브쿼리 작성
2. 해당하는 회원의 리뷰글 출력
3. REVIEW_DATE asc, MEMBER_PROFILE asc

1. 가장 많은 댓글 수를 구하는 서브쿼리 작성
2. 그 댓글 수와 같은 수의 멤버 아이디 구하기
3. 해당 멤버 아이디와 같은 멤버아이디의 리뷰글을 구하기

*/

# SELECT DISTINCT COUNT(*)
# FROM REST_REVIEW
# GROUP BY MEMBER_ID
# ORDER BY 1 DESC

SELECT MEMBER_NAME, REVIEW_TEXT, DATE_FORMAT(REVIEW_DATE, '%Y-%m-%d') REVIEW_DATE
FROM REST_REVIEW R JOIN MEMBER_PROFILE M
    ON R.MEMBER_ID = M.MEMBER_ID
WHERE R.MEMBER_ID IN
(SELECT MEMBER_ID
FROM REST_REVIEW
GROUP BY MEMBER_ID
HAVING COUNT(*) = (
SELECT COUNT(*)
FROM REST_REVIEW
GROUP BY MEMBER_ID
ORDER BY 1 DESC 
    LIMIT 1))
ORDER BY 3, 2








