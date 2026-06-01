def check(num):
    for c in str(num):
        if c == '3':
            return True
    return num % 3 == 0

def solution(n):
    ret = {}
    num = 1
    for i in range(1, n+1):
        ret[i] = num
        num += 1
        while check(num):
            num += 1
    return ret[n]
# 3배수, 3사용x