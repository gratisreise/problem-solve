-- 2022년 4월 13일 
-- 취소x, CS 진료 예약 내역
-- 진료예약일시 오름차
select a.APNT_NO, PT_NAME, a.PT_NO, a.MCDP_CD, d.DR_NAME, a.APNT_YMD
from APPOINTMENT a
join PATIENT p on a.PT_NO = p.PT_NO
join DOCTOR d on a.MDDR_ID = d.DR_ID
where 
    a.APNT_YMD like '2022-04-13%'
    and a.MCDP_CD = 'CS'
    and a.APNT_CNCL_YN = 'N'
order by a.APNT_YMD

# SELECT APNT_NO, PT_NAME, a.PT_NO, a.MCDP_CD, DR_NAME, APNT_YMD
# FROM APPOINTMENT a 
#     JOIN PATIENT p ON a.PT_NO = p.PT_NO
#     JOIN DOCTOR d ON MDDR_ID = DR_ID
# WHERE APNT_CNCL_YN = 'N'
#     AND a.MCDP_CD = 'CS'
#     AND APNT_YMD LIKE '2022-04-13%'
# ORDER BY APNT_YMD
