def solution(nums):
    if nums[-1] > nums[-2]:
        nums.append(nums[-1] - nums[-2])
    else:
        nums.append(nums[-1]*2)
    return nums