-- 종류 세단
-- 10월 대여 시작 기록
-- id중복금지
-- id내림차
select distinct(c1.car_id)
from CAR_RENTAL_COMPANY_RENTAL_HISTORY c1
left join CAR_RENTAL_COMPANY_CAR c2 on c1.CAR_ID = c2.CAR_ID
where month(START_DATE) = 10 and c2.car_type = '세단'
order by car_id desc
