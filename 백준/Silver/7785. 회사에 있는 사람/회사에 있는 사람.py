import sys
ip, op = sys.stdin, sys.stdout
n = int(ip.readline())
ret = {}
for _ in range(n):
    s = ip.readline().rstrip().split()
    if s[1] == 'enter': ret[s[0]] = 1
    else: ret[s[0]] = 0
ret = [key for key in ret.keys() if ret[key] == 1]
ret.sort(reverse=True)
op.write('\n'.join(ret)+'\n')