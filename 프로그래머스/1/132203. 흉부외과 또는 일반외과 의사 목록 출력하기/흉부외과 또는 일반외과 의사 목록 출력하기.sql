select dr_name, dr_id, mcdp_cd, hire_ymd
from doctor
where mcdp_cd IN ('CS', 'GS')
order by hire_ymd desc, dr_name asc


/*
진료과 = CS or GS, 
고용일자 desc, 이름 asc

이름, 의사id, 진료과, 고용일자


*/