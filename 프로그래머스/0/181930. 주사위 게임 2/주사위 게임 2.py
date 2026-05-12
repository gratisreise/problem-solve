from collections import Counter
def solution(a, b, c):
    cnt = Counter([a, b, c])
    if len(cnt) == 3:
        return a + b + c
    elif len(cnt) == 1:
        return (3*a) * (3*(a**2)) * 3*(a**3)
    else:
        return (a+b+c) *(a**2 + b**2 + c**2)