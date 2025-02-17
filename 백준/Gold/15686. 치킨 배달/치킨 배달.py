import sys
from itertools import combinations

ip, op = sys.stdin, sys.stdout
dy, dx = [-1, 0, 1, 0], [0, 1, 0, -1]
home, chi = [], []
n, m = map(int, ip.readline().rstrip().split())
mp = [0]*n
for i in range(n):
    mp[i] = list(map(int, ip.readline().rstrip().split()))
    for j in range(n):
        if mp[i][j] == 1:
            home.append((i,j))
        elif mp[i][j] == 2:
            chi.append((i,j))
ret = 1e9
for arr in list(combinations(chi, m)):
    sum = 0
    for h in home:
        dis = 1e9
        for c in arr:
            dis = min(dis, abs(h[0]-c[0])+abs(h[1]-c[1]))
        sum += dis
    ret = min(sum, ret)
op.write(f'{ret}\n')