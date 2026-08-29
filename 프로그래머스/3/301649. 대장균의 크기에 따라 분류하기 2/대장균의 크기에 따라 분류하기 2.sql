# 크기 내림차순 상윈 0~25 26~50 51~75, 76 ~100 ntile
# 개체id 오름차, 데이터 4배수, 같은 사이즈 없음
with pre1 as(
    select 
        *,
        ntile(4) over(order by size_of_colony desc) as ns
    from ecoli_data
)

select 
    id,
    case ns
        when 1 then 'CRITICAL'
        when 2 then 'HIGH'
        when 3 then 'MEDIUM'
        else 'LOW'
    end colony_name
from pre1
order by id asc
