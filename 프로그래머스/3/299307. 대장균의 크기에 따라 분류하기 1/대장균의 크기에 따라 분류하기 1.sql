# 100<= low, 100~1000 MEDIUM, 1000 > HIGH
# id asc
select 
    id,
    case 
        when size_of_colony <= 100 then 'LOW'
        when size_of_colony > 1000 then 'HIGH'
        else 'MEDIUM'
    end as size
from ecoli_data
order by id asc
