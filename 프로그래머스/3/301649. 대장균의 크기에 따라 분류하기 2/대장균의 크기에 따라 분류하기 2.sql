with temp as (
    select 
        id, 
        row_number() over(order by size_of_colony desc) as rn,
        count(*) over() as cnt
    from ecoli_data
)

select
    id,
    case
        when rn <= cnt * 1/4 then 'CRITICAL'
        when rn <= cnt * 2/4 then 'HIGH'
        when rn <= cnt * 3/4 then 'MEDIUM'
        else 'LOW'
    end as colony_name
from temp
order by id asc



/*
크기순 상위 4개 단위로 나눔
개체 id 오름차, 
데이터 4배수, 사이즈 중복x
순위 / 전체 행의 갯수가 1/4, 2/4, 3/4, 


*/