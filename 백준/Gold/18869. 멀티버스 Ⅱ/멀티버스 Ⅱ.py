import sys
import bisect
from collections import defaultdict


n, m = map(int, sys.stdin.readline().split())
count = defaultdict(int)

for _ in range(n):
    universe = list(map(int, sys.stdin.readline().split()))
    sorted_universe = sorted(universe)
    # 상대적 순위 계산
    normalized = tuple(bisect.bisect_left(sorted_universe, x) + 1 for x in universe)
    count[normalized] += 1

result = sum(k * (k - 1) // 2 for k in count.values())
print(result)