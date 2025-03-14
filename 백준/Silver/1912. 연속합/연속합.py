import sys
input = sys.stdin.readline
n = int(input())
nums = list(map(int, input().split()))
ret = -int(1e9)
ssum = 0
for num in nums:
    if ssum + num > 0:
        ssum += num
        ret = max(ret, ssum)
    else:
        ssum = 0
if ssum > 0: ret = max(ret, ssum)
if ret == -int(1e9):
    ret = max(nums)
print(ret)