select 
    round(avg(
        case
            when length is null then 10
            else length
        end 
    ), 2) as average_length
from fish_info

/*
평균길이 출력(,2f)
10cm 이하 = 10

*/