select category, sum(bs.sales) as total_sales
from book b
 join book_sales bs
    on b.book_id = bs.book_id
where sales_date like '2022-01%'
group by category 
order by category


/*
2022년 1월 카테고리별 도선 판매량 합산, 카테고리, 판매량
카테고리 오름차

*/