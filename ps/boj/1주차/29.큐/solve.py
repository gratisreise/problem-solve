from collections import deque
import sys

ip, op = sys.stdin, sys.stdout
q = deque()
n = int(ip.readline().rstrip())
ret = []
for _ in range(n):
    strs = ip.readline().rstrip().split()
    if strs[0] == 'push':
        q.append(int(strs[1]))
    elif strs[0] == 'pop':
        ret.append(q.popleft() if q else -1)
    elif strs[0] == 'size':
        ret.append(len(q))
    elif strs[0] == 'empty':
        ret.append(0 if q else 1)
    elif strs[0] == 'front':
        ret.append(q[0] if q else -1)
    elif strs[0] == 'back':
        ret.append(q[-1] if q else -1)
op.write('\n'.join(map(str,ret)) + '\n')