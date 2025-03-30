-- 대여시작일 2022년 9월
-- 대여기간 30일 이상 = 장기대여, 아니면 단기대여
select history_id, car_id, 
    date_format(start_date, '%Y-%m-%d') as START_DATE,
    date_format(end_date, '%Y-%m-%d') as END_DATE,
    CASE
        when DATEDIFF(END_DATE, START_DATE)+1 >= 30 Then '장기 대여'
        else '단기 대여' 
    end as RENT_TYPE
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where START_DATE like '%2022-09%'
order by HISTORY_ID desc