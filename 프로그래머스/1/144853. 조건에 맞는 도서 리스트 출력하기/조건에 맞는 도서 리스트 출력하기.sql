select book_id, date_format(published_date, '%Y-%m-%d') as published_date
from book
where published_date like '2021%' and category = '인문'
order by published_date


/*
book 2021년 출판, 카테고리 입문, book_id, published_date, 
출판일 오름차

*/