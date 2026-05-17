def solution(n):
    ret = 0
    for i in range(1, n+1):
        if i*i > n: break
        if n % i == 0:
            if i*i == n: ret += n//i
            else: ret += (n//i + i)
    return ret