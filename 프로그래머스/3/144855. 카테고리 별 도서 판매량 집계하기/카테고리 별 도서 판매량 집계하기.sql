# 2022년 1월, 카테고리별, 도서판매량합, 카테고리 오름차
select 
    b.category,
    sum(bs.sales) as total_sales
from book b join book_sales bs
on b.book_id = bs.book_id 
where bs.sales_date like '2022-01%'
group by b.category
order by b.category 