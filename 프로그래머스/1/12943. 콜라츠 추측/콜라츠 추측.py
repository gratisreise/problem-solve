def solution(num):
    ret = 0
    while num != 1:
        if num % 2:
            num = 3 * num + 1
        else:
            num //= 2
        ret += 1
        if ret >= 500: return -1
    return ret
"""



"""