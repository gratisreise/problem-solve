def solution(n):
    for i in range(1, n+1):
        if i*i > n: break
        if i*i == n: return (i+1) ** 2
    return -1