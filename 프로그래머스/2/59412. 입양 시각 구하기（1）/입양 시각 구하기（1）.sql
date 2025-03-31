-- 09:00 ~ 19:59 시간대별로 몇건의 입양이 발생 했는지 조회
-- 9~ 19 까지
select hour(datetime) as hour, count(*) as count from ANIMAL_OUTS
where hour(datetime) >= 9 and hour(datetime) <= 19
group by hour
order by hour
