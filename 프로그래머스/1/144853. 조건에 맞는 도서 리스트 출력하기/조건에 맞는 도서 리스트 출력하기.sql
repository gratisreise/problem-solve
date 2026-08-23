# 2021년 출판, 인문 카테고리, 
select book_id, published_date
from book 
where category = '인문' and year(published_date) = 2021
order by published_date asc