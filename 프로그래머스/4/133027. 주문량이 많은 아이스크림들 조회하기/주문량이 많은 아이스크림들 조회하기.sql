-- 7월 총주문량
-- 상반기 총주문량
-- 합의 내림차 3개
select f.FLAVOR
from FIRST_HALF f
join JULY j on f.FLAVOR = j.FLAVOR
group by j.FLAVOR
order by (f.TOTAL_ORDER + sum(j.TOTAL_ORDER)) desc
limit 3