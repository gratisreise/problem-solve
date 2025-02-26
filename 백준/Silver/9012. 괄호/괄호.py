import sys
from collections import deque
ip, op = sys.stdin, sys.stdout
t = int(ip.readline().rstrip())
ret = []
for _ in range(t):
    s = ip.readline().rstrip()
    stk = deque()
    for c in s:
        if stk and c == ')' and stk[-1] == '(':
            stk.pop()
        else:
            stk.append(c)
    ret.append("NO" if stk else "YES")
op.write('\n'.join(ret)+'\n')