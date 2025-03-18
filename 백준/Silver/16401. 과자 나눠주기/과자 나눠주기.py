import sys
input = sys.stdin.readline


m, n = map(int, input().split())

ls = list(map(int, input().split()))
l, r = 1, max(ls)

def check(mid):
    cnt = 0
    for l in ls:
        cnt += l // mid
    return cnt >= m

ret = 0
while l <= r:
    mid = (l + r) // 2
    if check(mid):
        l = mid + 1
        ret = mid
    else:
        r = mid - 1
print(ret)