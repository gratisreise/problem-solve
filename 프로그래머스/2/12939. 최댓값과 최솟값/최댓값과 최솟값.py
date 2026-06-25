def solution(s):
    s = list((int(x) for x in s.split(" ")))
    return f"{min(s)} {max(s)}"