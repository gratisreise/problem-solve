import sys

ip, op = sys.stdin, sys.stdout

n = int(ip.readline())
ret = {}

for _ in range(n):
    name, action = ip.readline().rstrip().split()
    if action == 'enter': ret[name] = 1
    else: ret[name] = 0
ret = [key for key in ret.keys() if ret[key] == 1]
ret.sort(reverse=True)
op.write('\n'.join(ret) + '\n')