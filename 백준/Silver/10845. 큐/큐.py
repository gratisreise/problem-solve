from collections import deque
import sys

ip, op = sys.stdin, sys.stdout
q = deque()
n = int(ip.readline().rstrip())
ret = []
for _ in range(n):
    strs = input().split()
    if strs[0] == 'push':
        q.append(int(strs[1]))
    elif strs[0] == 'pop':
        if q:
            ret.append(q.popleft())
        else: ret.append(-1)
    elif strs[0] == 'size':
        ret.append(len(q))
    elif strs[0] == 'empty':
        if not q: ret.append(1)
        else: ret.append(0)
    elif strs[0] == 'front':
        if q: ret.append(q[0])
        else: ret.append(-1)
    elif strs[0] == 'back':
        if q: ret.append(q[-1])
        else: ret.append(-1)
op.write('\n'.join(map(str,ret)) + '\n')
        