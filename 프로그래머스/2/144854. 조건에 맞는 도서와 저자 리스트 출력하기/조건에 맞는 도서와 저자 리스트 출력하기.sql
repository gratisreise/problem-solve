select book_id, author_name, published_date
from book b
join author a
on b.author_id = a.author_id
where b.category = '경제'
order by b.published_date



/*
카테고리 = 경제

*/