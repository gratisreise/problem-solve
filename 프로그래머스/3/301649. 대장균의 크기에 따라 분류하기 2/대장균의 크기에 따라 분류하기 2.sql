with ranked as (
    select 
        id, 
        row_number() over(order by size_of_colony desc) as rn,
        count(*) over() as total
    from ecoli_data
)

select
    id,
    case
        when rn <= total / 4 then 'CRITICAL'
        when rn <= total / 2 then 'HIGH'
        when rn <= total *3 / 4 then 'MEDIUM'
        else 'LOW'
    end as COLONY_NAME
from ranked
order by id

# select * from ranked

/*
대장균 크기 내림차순 
사우이 0~25% CRITICAL
26~50% 'HIGH'
51~75% 'MEDIUM'
76~100% 'LOW'


*/