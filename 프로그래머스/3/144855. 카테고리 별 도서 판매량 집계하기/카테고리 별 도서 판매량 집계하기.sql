select b.category, sum( s.sales) as total_sales
from book b
join book_sales s
on b.book_id = s.book_id
where s.sales_date like '2022-01%'
group by b.category
order by b.category



/*
2022년 1월
카테고리별
도서 판매량
카테고리 오름차
*/