def solution(arr, divisor):
    ret = sorted(x for x in arr if x % divisor == 0) 
    return ret if ret else [-1] 