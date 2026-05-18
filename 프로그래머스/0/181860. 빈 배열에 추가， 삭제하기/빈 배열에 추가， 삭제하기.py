def solution(arr, flag):
    ret = []  
    for i, x in enumerate(arr):
        if flag[i]:
            ret += [x] * (2*x)
        else:
            ret = ret[:(len(ret) - x)]
    return ret