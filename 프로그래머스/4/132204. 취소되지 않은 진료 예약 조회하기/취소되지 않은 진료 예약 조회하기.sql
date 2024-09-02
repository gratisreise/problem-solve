/*
- 2022년 4월 13일
- 취소X CS 진료 예약
- 진료예약번호, 환자이름, 환자번호, 진료과코드, 의사이름, 진료예약일시
- 진료예약일시 asc
1. patient 조인 환자정보, doctor 조인 의사정보
2. APNT_CNCL_YN = N 조건설정
3. APNT_YMD ASC
4. 조회
*/
SELECT APNT_NO, PT_NAME, a.PT_NO, a.MCDP_CD, DR_NAME, APNT_YMD
FROM APPOINTMENT a 
    JOIN PATIENT p ON a.PT_NO = p.PT_NO
    JOIN DOCTOR d ON MDDR_ID = DR_ID
WHERE APNT_CNCL_YN = 'N'
    AND a.MCDP_CD = 'CS'
    AND APNT_YMD LIKE '2022-04-13%'
ORDER BY APNT_YMD
