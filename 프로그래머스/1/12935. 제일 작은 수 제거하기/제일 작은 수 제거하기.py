def solution(arr):
    idx = arr.index(min(arr))
    ret = [x for i,x in enumerate(arr) if i != idx]
    return ret if ret else [-1]