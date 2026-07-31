select id, name, host_id
from places
where host_id in (
    select host_id 
    from places
    group by host_id
    having count(*) >= 2
)
order by id asc


/*
공간 둘 이상 등록 => 헤비유저
헤비유저가 등록한 공간의 정보
아이디 오름차


*/