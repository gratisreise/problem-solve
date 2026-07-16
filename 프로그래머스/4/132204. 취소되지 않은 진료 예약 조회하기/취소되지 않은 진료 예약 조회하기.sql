select a.apnt_no, p.pt_name, p.pt_no, a.mcdp_cd, d.dr_name, a.apnt_ymd
from appointment a
join doctor d
on d.dr_id = a.mddr_id 
join patient p
on p.pt_no = a.pt_no 
where a.apnt_ymd like '2022-04-13%' and a.apnt_cncl_ymd is null and a.mcdp_cd = 'CS'
order by apnt_ymd asc 


/*
2022년 4월 13일 
취소x, CS, 
진료예약일시 asc


*/