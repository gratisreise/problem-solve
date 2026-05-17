def solution(n):
    n = str(n)
    return [int(n[i]) for i in range(-1, -len(n)-1, -1)]
        