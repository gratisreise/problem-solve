select book_id, author_name, published_date
from book b join author a
    on b.author_id = a.author_id
where category = '경제'
order by published_date


/*
카테고리 = 경제,
출판일 오름차
도서id, 저자명, 출판일

*/