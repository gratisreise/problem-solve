select 
    mcdp_cd as 진료과코드,
    count(*) as 5월예약건수
from appointment
where apnt_ymd like '2022-05%'
group by mcdp_cd
order by 5월예약건수, 진료과코드

/*
2022년 5월, 
진료과코드별
환자수 오름차, 코드 오름차

*/