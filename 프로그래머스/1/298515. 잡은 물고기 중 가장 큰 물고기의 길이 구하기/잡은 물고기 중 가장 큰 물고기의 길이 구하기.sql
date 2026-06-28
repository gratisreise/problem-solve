select concat(max(ifnull(length, 10)), 'cm') as max_length
from fish_info

/*
잡은 물고기, max 물고기 길이 cm 

*/