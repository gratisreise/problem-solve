def solution(n):
    if n == 1: return [1]
    answer = set()
    for i in range(1, n+1):
        if i * i > n: break
        if n % i == 0:
            answer.add(i)
            answer.add(n//i)
    return sorted(list(answer))