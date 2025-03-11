import sys, heapq
input = sys.stdin.readline
n, k = map(int, input().split())
jew = [tuple(map(int, input().split())) for _ in range(n)]
bags = [int(input()) for _ in range(k)]
jew.sort()
bags.sort()
i, ret, ans = 0, [], 0
for bag in bags:
    while (0 <= i < len(jew)) and jew[i][0] <= bag:
        heapq.heappush(ret, -jew[i][1])
        i += 1
    if ret: ans += -heapq.heappop(ret)
print(ans)