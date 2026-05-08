def solution(n):
    for i in range(n + 1):
        if (i * i) >n:
            break
        if i * i == n:
            return 1
    return 2