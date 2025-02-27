import sys
from collections import deque
ip, op = sys.stdin, sys.stdout

n = int(ip.readline().rstrip())
a = list(map(int, ip.readline().rstrip().split()))
ret = [-1]*n
stk = deque()
for i in range(n):
    while stk and a[stk[-1]] < a[i]:
        ret[stk.pop()] = a[i]
    stk.append(i)
op.write(' '.join(map(str, ret))+'\n')