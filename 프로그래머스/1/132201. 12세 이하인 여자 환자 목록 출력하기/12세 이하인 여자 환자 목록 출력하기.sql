select pt_name, pt_no, gend_cd, age, ifnull(tlno, "NONE") as tlno
from patient
where age <= 12 and gend_cd = 'W'
order by  age desc, pt_name



/*
12세이하, 여자, 
전화번호==null => 'NONE'
나이 내림차, 환자이름 오름차

환자이름, 환자번호, 성별코드, 나이, 전화번호

*/