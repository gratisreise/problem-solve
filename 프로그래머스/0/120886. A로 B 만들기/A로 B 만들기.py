from collections import Counter
def solution(before, after):
    cnt1 = Counter(before)
    cnt2 = Counter(after)
    for x in cnt1.keys():
        if cnt1[x] != cnt2[x]:
            return 0
    return 1