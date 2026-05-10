def solution(arr):
    ret = []
    for num in arr:
        for _ in range(num):
            ret.append(num)
    return ret