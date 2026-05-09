def solution(hp):
    nums = [5, 3, 1]
    ret = 0
    for num in nums:
        ret += hp // num
        hp %= num
    ret += hp
    return ret