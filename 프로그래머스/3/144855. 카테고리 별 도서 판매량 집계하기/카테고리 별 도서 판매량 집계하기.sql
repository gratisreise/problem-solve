-- 2022년 1월 
-- 카테고리 별 도서 판매량 합산
-- 카테고리 오름차
select b2.category, sum(b1.sales ) as total_sales
from BOOK_SALES b1
left join book b2 on b1.book_id = b2.book_id
where b1.sales_date like '2022-01%'
group by b2.category
order by b2.category