def solution(a, b):
    return sum(x1 * x2 for x1, x2 in zip(a, b))