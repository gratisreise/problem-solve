def solution(arr, queries):
    ret = []
    for q in queries:
        s, e, k = q
        mn = 1000000000
        for i in range(s, e + 1):
            if arr[i] > k:
                mn = min(mn, arr[i])
        ret.append(mn if mn != 1000000000 else -1 )
    return ret