import sys
input = sys.stdin.readline

n, l = map(int, input().split())
pos = [tuple(map(int, input().split())) for _ in range(n)]
pos.sort()
now, ret = 0, 0
for s, e in pos:
    if s <= now:  s = now + 1
    size = e - s
    if size % l == 0:
        ret += size // l
        now = e
    else:
        ret += (size//l) + 1
        now = s + l*(size//l + 1) - 1
print(ret)