select b.author_id, author_name, category, sum(price * sales) as total_sales
from book b 
 join author a 
  on b.author_id = a.author_id
 join book_sales bs
  on b.book_id = bs.book_id
where sales_date like '2022-01%'
group by author_name, category
order by b.author_id, category desc

/*
2022년 1월 
저자별, 카테고리 별, 매출액(판매량 * 판매가)
저자id, 카테고리 desc

저자id, 저자명, 카테고리, 매출액


*/