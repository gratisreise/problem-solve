import sys
from collections import defaultdict
ip, op = sys.stdin, sys.stdout
k,l = map(int, ip.readline().split())
data = {}
for _ in range(l):
    s = ip.readline().rstrip()
    if s in data:
        del data[s]
    data[s] = 1
for key in list(data.keys())[:k]:
    op.write(f"{key}\n")