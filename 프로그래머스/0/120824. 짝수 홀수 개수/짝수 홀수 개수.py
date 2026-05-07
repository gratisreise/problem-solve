def solution(nums):
    return [sum(1 for n in nums if n % 2 == 0), sum(1 for n in nums if n % 2 == 1)]