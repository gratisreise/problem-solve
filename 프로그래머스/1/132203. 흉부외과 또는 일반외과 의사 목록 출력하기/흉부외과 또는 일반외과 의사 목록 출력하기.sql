select dr_name, dr_id, mcdp_cd, hire_ymd
from doctor
where mcdp_cd IN ('CS', 'GS')
order by hire_ymd desc, dr_name asc


/*
진료과 = CS or GS
고용일자 내림차, 이름 오름차

*/