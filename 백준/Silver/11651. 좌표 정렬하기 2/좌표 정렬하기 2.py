import sys
ip, op = sys.stdin, sys.stdout
n = int(ip.readline())
ret = []
for _ in range(n):
    x,y = map(int, ip.readline().split())
    ret.append((x, y))
ret.sort(key=lambda d: (d[1],d[0]))
op.write('\n'.join(' '.join((str(x), str(y))) for x,y in ret)+'\n')