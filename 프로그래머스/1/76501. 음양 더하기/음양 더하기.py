def solution(absolutes, signs):
    return sum(x if signs[i] else -x for i,x in enumerate(absolutes))