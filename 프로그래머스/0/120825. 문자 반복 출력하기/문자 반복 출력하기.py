def solution(my_string, n):
    ret = ''
    for c in my_string:
        for _ in range(n):
            ret += c
    return ret