def count(n):
    cnt = 0
    for x in range(1, n+1):
        if x ** 2 > n: break
        if n % x == 0:
            if x ** 2 == n:
                cnt += 1
            else: cnt += 2
    return cnt

def solution(n):
    return sum(1 for x in range(4, n+1) if count(x) >= 3)