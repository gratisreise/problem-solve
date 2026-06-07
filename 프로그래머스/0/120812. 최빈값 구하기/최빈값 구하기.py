from collections import Counter
def solution(array):
    cnt1 = Counter(array)
    cnt2 = Counter(cnt1.values())
    temp = sorted(cnt1.keys(), key = lambda x: cnt1[x])
    return temp[-1] if cnt2[cnt1[temp[-1]]] == 1 else -1
    
    