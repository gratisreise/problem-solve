select concat_ws('/', '/home/grep/src', board_id, concat_ws('',file_id, file_name,file_ext))
 as file_path
from used_goods_file
where board_id = (
    select board_id  
    from used_goods_board
    order by views desc
    limit 1
)
order by file_id desc

/*
조회수max, 중고거래 게시물에 대한 첨부파일 경로 
fileid 내림차, 
게시글id 기준 디렉토리 구분, 파일이름 = 파일id + 파일이름 + 파일 확장자 
조회수 max는 하나만 존재
*/