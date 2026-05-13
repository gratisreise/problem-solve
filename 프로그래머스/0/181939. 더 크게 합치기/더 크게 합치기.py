def solution(a, b):
    a, b = str(a), str(b)
    return int(a + b) if (a + b) >= (b + a) else int(b + a)