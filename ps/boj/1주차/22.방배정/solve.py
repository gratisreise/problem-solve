from collections import defaultdict
ret = defaultdict(int)
n, k = map(int, input().split())
for _ in range(n):
    ret[input()] += 1
cnt = 0
for num in ret.values():
    cnt += (num + k - 1) // k
print(cnt)