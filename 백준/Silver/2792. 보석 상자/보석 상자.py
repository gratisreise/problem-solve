import sys
input = sys.stdin.readline
n,m  = map(int, input().split())
nums = []
for _ in range(m):
    nums.append(int(input()))
l, r = 1, max(nums)
ret = int(1e9)
def check(mid):
    global n
    cnt = 0
    for num in nums:
        temp = num // mid if num % mid == 0 else num // mid + 1 
        cnt += temp
        if cnt > n:
            return False
    return True
while l <= r:
    mid = (l + r) // 2
    if check(mid):
        r = mid - 1
        ret = min(ret, mid)
    else:
        l = mid + 1
print(ret)