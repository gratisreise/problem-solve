def solution(arr, k):
    ret, st = [], set()
    for x in arr:
        if x not in st:
            ret.append(x)
            st.add(x)
        if len(ret) == k: break
        
    while len(ret) < k:
        ret.append(-1)
    return ret
    
    