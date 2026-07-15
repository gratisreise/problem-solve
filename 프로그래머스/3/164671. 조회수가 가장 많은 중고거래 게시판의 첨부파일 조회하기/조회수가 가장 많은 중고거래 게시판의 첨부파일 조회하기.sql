select 
    concat_ws('/', '/home/grep/src', board_id, concat_ws('', file_id, file_name, file_ext)) as file_path
from used_goods_file
where board_id = (
    select board_id 
    from used_goods_board
    order by views desc
    limit 1
)
order by file_id desc

/*
조회수 max, 첨부파일 경로,


*/