import sys
from collections import defaultdict
ip = sys.stdin
op = sys.stdout

n = int(ip.readline())
data = defaultdict(int)
for _ in range(n):
    data[int(ip.readline())] += 1
data = sorted(data.items())
for a, b in data:
    for _ in range(b):
        op.write(str(a) +'\n')