n = int(input())
nums = list(map(int, input().split()))
nums.sort()
x = int(input())
if len(nums) >= 2 and nums[-1] + nums[-2] < x:
    print(0)
    exit()
ret = 0
l, r = 0, n - 1
while l < r:
    sum = nums[l] + nums[r]
    if sum < x: l += 1
    elif sum > x: r -= 1
    else: 
        ret += 1
        r -= 1
print(ret)