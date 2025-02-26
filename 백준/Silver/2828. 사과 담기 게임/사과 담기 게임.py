n, m = map(int, input().split())
j = int(input())
l, ret = 1, 0
for _ in range(j):
    r = l + m  - 1
    pos = int(input())
    if l <= pos <= r: continue
    elif pos < l:
        ret += (l - pos)
        l = pos
    elif pos > r:
        ret += (pos - r)
        l += (pos - r)
print(ret)