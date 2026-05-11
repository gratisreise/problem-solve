def solution(numbers, n):
    ret = 0
    for num in numbers:
        ret += num
        if ret > n: return ret
    return ret