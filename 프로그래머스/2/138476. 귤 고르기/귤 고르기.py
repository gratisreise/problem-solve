from collections import Counter
def solution(k, tangerine):
    cnt = Counter(tangerine)
    keys = sorted(list(cnt.keys()), key=lambda x: -cnt[x])
    temp, ret = 0, 0
    for key in keys:
        temp += cnt[key]
        ret += 1
        if temp >= k:
            return ret
    
    
    