def solution(n):
    n = sorted([c for c in str(n)], reverse=True)
    return int(''.join(c for c in n))