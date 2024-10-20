def solution(arr, flag):
    ret = []
    for i, f in enumerate(flag):
        if f: ret.extend([arr[i]] * (arr[i] * 2))
        else: ret = ret[:-arr[i]]
    return ret
