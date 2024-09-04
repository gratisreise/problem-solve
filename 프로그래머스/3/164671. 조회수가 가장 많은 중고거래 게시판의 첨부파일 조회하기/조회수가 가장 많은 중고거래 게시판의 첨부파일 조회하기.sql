/*
- 조회수 max 첨부파일 경로 조회
- FILE ID 내림차
- 기본파일경로 /home/grep/src/ 
- 게시글 ID 기준 디렉토리 구분
- 파일이름: 파일 ID, 파일 이름, 파일 확장자로 구성
- !조회수가 가장 높은 게시물은 하나만 존재!
1. 테이블 조인
2. max 게시물 조건 설정
3. 해당하는 게시물 첨부파일 출력
*/
SELECT CONCAT('/home/grep/src/', F.BOARD_ID, 
              '/',FILE_ID, FILE_NAME, FILE_EXT) FILE_PATH
FROM USED_GOODS_BOARD B JOIN USED_GOODS_FILE F
ON B.BOARD_ID = F.BOARD_ID
WHERE VIEWS = (select max(VIEWS) from USED_GOODS_BOARD)
ORDER BY FILE_ID DESC
