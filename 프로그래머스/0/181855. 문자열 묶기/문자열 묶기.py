from collections import Counter
def solution(strArr):
    cnt = Counter([len(x) for x in strArr])
    return max(cnt.values())
    