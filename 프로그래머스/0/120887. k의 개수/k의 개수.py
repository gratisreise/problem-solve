from collections import Counter
def solution(i, j, k):
    ret = 0
    for x in range(i, j+1):
        cnt = Counter(str(x))
        ret += cnt[str(k)]
    return ret