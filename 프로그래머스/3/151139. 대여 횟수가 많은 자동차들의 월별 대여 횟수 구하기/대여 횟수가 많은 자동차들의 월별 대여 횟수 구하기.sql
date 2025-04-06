-- 대여시작일 2022 8~10월
-- 대여 횟수 5회 이상 자동차
-- 월별 자동차id별 대여 횟수
-- 월 오름차, id내림차
select month(START_DATE) as MONTH, 
    CAR_ID, 
    count(*) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where CAR_ID in
(select CAR_ID
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where start_date BETWEEN '2022-08-01' AND '2022-10-31'
group by CAR_ID
having count(*) >= 5) and start_date BETWEEN '2022-08-01' AND '2022-10-31'
group by MONTH, CAR_ID
order by MONTH, CAR_ID desc

