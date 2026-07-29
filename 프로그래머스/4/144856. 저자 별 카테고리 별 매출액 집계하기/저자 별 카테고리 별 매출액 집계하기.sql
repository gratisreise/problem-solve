select
    a.author_id,
    a.author_name,
    b.category,
    sum(price * sales) as total_sales
from book b
join author a
on b.author_id = a.author_id
join book_sales bs
on bs.book_id = b.book_id
where bs.sales_date like '2022-01%'
group by a.author_id, category 
order by a.author_id asc, category desc



/*
2022년 1월
저자별, 카테고리별
매출액



*/