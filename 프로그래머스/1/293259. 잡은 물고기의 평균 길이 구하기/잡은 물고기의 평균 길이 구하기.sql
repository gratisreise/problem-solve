-- 평균길이, 컬럼명 AVERAGE_LENGTH, 길이 셋째에서 반올림, null은 10으로 취급

select round(avg(ifnull(length, 10)), 2) as AVERAGE_LENGTH from fish_info