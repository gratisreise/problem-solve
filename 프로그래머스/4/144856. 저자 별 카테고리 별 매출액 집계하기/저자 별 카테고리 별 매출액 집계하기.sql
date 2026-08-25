# 2022년 1월, 저자asc, 카테고리desc, 저자별, 카테고리별

select a.author_id, a.author_name, b.category, sum(b.price * bs.sales) as total_sales
from book b join author a
on b.author_id = a.author_id
join book_sales bs 
on b.book_id = bs.book_id 
where bs.sales_date like '2022-01%'
group by a.author_id, b.category
order by a.author_id asc, category desc 
