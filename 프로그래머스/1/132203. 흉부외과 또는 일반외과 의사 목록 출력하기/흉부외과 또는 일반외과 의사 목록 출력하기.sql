select 
    dr_name, 
    dr_id, 
    mcdp_cd, 
    date_format(hire_ymd, '%Y-%m-%d') as hire_ymd
from doctor
where mcdp_cd in ('CS', 'GS')
order by 4 desc, 1 asc



-- doctor 
-- 진료과 CS, GS, 
-- 의사이름, 의사id, 진료과, 고용일자
-- 고용일자 내림차, 이름 오름차