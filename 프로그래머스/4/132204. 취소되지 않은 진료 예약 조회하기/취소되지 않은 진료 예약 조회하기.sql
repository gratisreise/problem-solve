select a.apnt_no, p.pt_name, p.pt_no, d.mcdp_cd, d.dr_name, a.apnt_ymd
from appointment a
 join patient p
 on a.pt_no = p.pt_no
 join doctor d
 on a.mddr_id = d.dr_id
where a.apnt_cncl_yn = 'N' and d.mcdp_cd = 'CS' and a.apnt_ymd like '2022-04-13%'
order by a.apnt_ymd 


/*
2022년 4월 13일
취소되지 않은, CS, 진료예약내역
진료예약번호, 환자이름, 환자번호, 진료과코드, 의사이름, 진료예약일시
진료예약일시 오름차


*/