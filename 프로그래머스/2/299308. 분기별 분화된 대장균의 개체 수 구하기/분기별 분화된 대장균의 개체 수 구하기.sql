with ed as (
    select 
        id, 
        case 
            when floor((month(differentiation_date)-1)/3) = 0 then '1Q'
            when floor((month(differentiation_date)-1)/3) = 1 then '2Q'
            when floor((month(differentiation_date)-1)/3) = 2 then '3Q'
            else '4Q'
        end as quarter
    from ecoli_data
)
select quarter, count(*) as ecoli_count
from ed
group by quarter
order by quarter
/*
123
456
789
1011,12
각 분기별
대장균의 개체 총수
12를 기준으로 1/4인 
윈도우 함수로 각각의 분기를 계산해서 넣어주고 그리고 그룹핑해서 카운트 하기 

*/