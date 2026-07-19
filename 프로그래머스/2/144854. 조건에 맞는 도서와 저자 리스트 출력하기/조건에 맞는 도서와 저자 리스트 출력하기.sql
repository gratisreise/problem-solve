select b.book_id, a.author_name, b.published_date
from book b
join author a
on b.author_id = a.author_id
where b.category = '경제'
order by published_date 


/*
경제 카테고리
도서ID, 저자명, 출판일
출판일 오름차

*/