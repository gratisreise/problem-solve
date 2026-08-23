# cs or gs, 고용일자 내림차, 이름 오름차
select dr_name, dr_id, mcdp_cd, hire_ymd
from doctor
where mcdp_cd = 'CS' or mcdp_cd = 'GS'
order by hire_ymd desc, dr_name asc