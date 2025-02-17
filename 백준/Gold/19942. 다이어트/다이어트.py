import sys
from collections import defaultdict
ip, op = sys.stdin, sys.stdout
def check(p, f, s, v):
    return p >= mp and f >= mf and s >= ms and v >= mv
n = int(ip.readline().rstrip())
mp, mf, ms, mv = map(int, ip.readline().rstrip().split())
data = []
for _ in range(n):
    data.append(tuple(map(int, ip.readline().rstrip().split())))

ret = 1e9
ans = defaultdict(list)
for i in range(1, 1 << n):
    sump, sumf, sums, sumv, sumc = [0]*5
    temp = []
    for j in range(n):
        if i & (1 << j):
            sump += data[j][0]
            sumf += data[j][1]
            sums += data[j][2]
            sumv += data[j][3]
            sumc += data[j][4]
            temp.append(j+1)

    if sumc <= ret and check(sump, sumf, sums, sumv) :
        ret = sumc
        ans[sumc].append(tuple(temp))
if ret == 1e9: op.write("-1\n")
else:
    ans = sorted(ans[ret])
    op.write(f'{ret}\n')
    op.write(' '.join(map(str, sorted(ans[0])))+'\n')