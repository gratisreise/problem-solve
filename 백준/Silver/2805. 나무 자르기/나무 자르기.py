import sys

n, m = map(int, input().split())
heights = list(map(int, input().split()))
l, r = 0, max(heights)

def check(mid):
    total = 0
    for h in heights:
        total += max(0, h - mid)
    return total >= m

ret = 0
while l <= r:
    mid = (l + r) // 2
    if check(mid):
        l = mid + 1
        ret = mid
    else:
        r = mid - 1
print(ret)