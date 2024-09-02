/*
- 게시물 3건 이상
- 사용자 id, 닉네임, 전체주소, 전화번호
- 주소(시 + 도로명 주소 + 상세 주소), 전화번호(000-0000-0000)
- 회원ID 내림차
1. 서브쿼리 3건 이상인 조건 설정
2. concat을 사용하여 컬럼 합치기, subtr '-' 넣기
3. 회원 ID를 기준으로 내림차순
*/
SELECT USER_ID, NICKNAME,
CONCAT(CITY,' ',STREET_ADDRESS1,' ',STREET_ADDRESS2) AS 전체주소,
CONCAT(SUBSTR(TLNO, 1, 3), '-', SUBSTR(TLNO, 4, 4), '-', SUBSTR(TLNO, 8, 4)) AS 전화번호
FROM USED_GOODS_USER
WHERE (
    SELECT COUNT(*) FROM USED_GOODS_BOARD
    WHERE USER_ID = WRITER_ID) >= 3
ORDER BY USER_ID DESC

