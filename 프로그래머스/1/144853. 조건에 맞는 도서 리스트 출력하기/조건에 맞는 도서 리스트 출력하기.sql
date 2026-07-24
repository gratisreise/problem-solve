select book_id, published_date
from book 
where year(published_date) = 2021 and category = '인문'
order by published_date

/*
2021년 출판 
인문 카테고리 
출판일 오름차

*/