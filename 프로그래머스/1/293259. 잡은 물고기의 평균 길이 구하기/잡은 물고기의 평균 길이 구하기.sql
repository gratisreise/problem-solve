select round(avg(ifnull(length, 10)), 2) as average_length
from fish_info


/*
평균길이(average_length, 소수3째반올림, 10cm이하 10cm 취급)


*/