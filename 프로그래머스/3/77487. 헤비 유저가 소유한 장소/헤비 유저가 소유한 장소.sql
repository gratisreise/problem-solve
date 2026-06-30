select id, name, host_id
from places
where host_id in (
    select host_id
    from places
    group by host_id 
    having count(*) >= 2
)
order by id

/*
공간을 둘 이상등록한 유저
아이디순 


공간의 정보

*/