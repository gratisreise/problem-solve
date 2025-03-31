-- 상품카테고리 코드끼리 갯수를 출력하는 sql문
select left(PRODUCT_CODE, 2) as CATEGORY, count(*) as PRODUCTS from product
group by CATEGORY
order by CATEGORY

