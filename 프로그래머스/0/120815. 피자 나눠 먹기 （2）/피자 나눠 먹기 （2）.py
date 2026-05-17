def solution(n):
    for x in range(1, 101):
        if (x*6) % n == 0:
            return x