def solution(a, b, n):
    ret = 0
    while n >= a:
        temp = (n // a) * b
        ret += temp
        n = (n % a) + temp
    return ret
    
"""
빈병 2 -> 꽉병 1
현재 // 2 => 다음에 낼거
현재 % 2 => 내고 남은 거 
둘이 더해서 다음 걸로 ㄱㄱ

"""