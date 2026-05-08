def solution(s1, s2):
    s1, s2 = set(s1), set(s2)
    return len(s1 & s2)