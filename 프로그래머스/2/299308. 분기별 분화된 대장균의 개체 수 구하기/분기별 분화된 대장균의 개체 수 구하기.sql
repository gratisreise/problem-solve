# 분기별 개체수, 분기오름차,
with pre1 as (
    select 
    *,
    concat(floor((month(differentiation_date)-1)/3)+1, 'Q') as quarter
    from ecoli_data
)

select quarter, count(*) as ecoli_count
from pre1
group by quarter 
order by quarter

    