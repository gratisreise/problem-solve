/*
- 공간 >=2 '헤비 유저'
- 아이디 오름차
1. 공간 둘이상 조건 설정
2. 아이디 오름차 조회
*/
select * from places
where HOST_ID IN (select HOST_ID from places
group by HOST_ID
having count(*) >= 2)
ORDER BY ID

