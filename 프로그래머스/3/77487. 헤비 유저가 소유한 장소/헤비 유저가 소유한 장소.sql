-- 공간 >= 2 : 헤비유저
-- 헤비유저가 등록한 공간 정보 
-- 아이디 오름차
select id, name, host_id
from PLACES
where HOST_ID in (
    select HOST_ID from PLACES 
    group by HOST_ID
    having count(*) >= 2
)
order by id 