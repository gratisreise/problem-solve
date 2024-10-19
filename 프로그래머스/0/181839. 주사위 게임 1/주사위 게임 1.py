def solution(a, b):
    if a % 2 == 0 and b % 2 == 0: return abs(a - b)
    elif a % 2 != 0 and b % 2 != 0: return a*a + b*b
    else: return 2 * (a + b)