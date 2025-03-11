import sys, heapq
input = sys.stdin.readline
n = int(input())
data = []
for _ in range(n):
    d, c = map(int, input().split())
    data.append((d, c))
data.sort()
ret = []
for d, c in data:
    heapq.heappush(ret, c)
    if len(ret) > d:
        heapq.heappop(ret)
print(sum(ret))