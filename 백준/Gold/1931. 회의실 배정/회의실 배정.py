import sys
input = sys.stdin.readline
n = int(input())
data = [tuple(map(int, input().split())) for _ in range(n)]
data.sort(key=lambda x: (x[1], x[0]))
time, ret = data[0][1], 1
for s, e in data[1:]:
    if s < time: continue
    time = e
    ret += 1
print(ret)