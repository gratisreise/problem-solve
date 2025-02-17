import sys
from collections import deque
ip, op = sys.stdin, sys.stdout

dy,dx = [-1, 0, 1, 0], [0, 1, 0, -1]
n,m = map(int, ip.readline().split())
mp =[list(map(int, list(ip.readline().rstrip()))) for _ in range(n)]
vis = [[0]*m for _ in range(n)]
q = deque()
q.append((0,0))
vis[0][0] = 1

while q:
    y,x = q.popleft()
    for d in range(4):
        ny, nx = y + dy[d], x + dx[d]
        if ny < 0 or ny >= n or nx < 0 or nx >= m:
            continue
        if vis[ny][nx] or mp[ny][nx] == 0: continue
        q.append((ny, nx))
        vis[ny][nx] = vis[y][x] + 1
op.write(f"{vis[n-1][m-1]}\n")   