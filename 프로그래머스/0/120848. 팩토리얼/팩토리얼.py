import math
def facto(n):
    return math.prod(x for x in range(1, n+1))

def solution(n):
    ret = 1
    for i in range(1, 11):
        if facto(i) <= n:
            ret = i
    return ret