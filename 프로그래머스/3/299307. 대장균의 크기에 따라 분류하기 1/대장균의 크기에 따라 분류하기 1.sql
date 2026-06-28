select id, 
    case 
        when size_of_colony <= 100 then 'LOW'
        when size_of_colony > 1000 then 'HIGH'
        else 'MEDIUM'
    end as size
from ecoli_data 
order by id 

/*
대장균 개체 100이하 'LOW', 100초과 1000이하'MEDIUM', 1000초과 'HIGH'
id오름차

id, size 


*/