def solution(array, n):
    array = sorted(array, reverse=True)
    mmin = 10000000000
    ret = -1
    for x in array:
        if abs(x - n) <= mmin:
            ret = x
            mmin = abs(x-n)
    return ret
            