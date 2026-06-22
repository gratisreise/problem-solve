# select mcdp_cd as 진료과코드, count(*) as 5월예약건수
# from appointment
# where apnt_ymd like '2022-05%'
# group by mcdp_cd
# order by 2, 1


select mcdp_cd as '진료과코드', count(*) as '5월예약건수'
from appointment
where apnt_ymd like '2022-05%'
group by mcdp_cd
order by 5월예약건수 asc, 진료과코드 asc


# /*
# 2022년 5월 예약한 
# 진료과코드별 
# 컬럼명: 진료과코드, 5월예약건수
# 환자수 오름차, 진료과 코드 오름차

# 환자수

# */