import sys
from collections import deque
dy, dx = [-1, 0, 1, 0],[0, 1, 0, -1]
ip, op = sys.stdin.readline, sys.stdout.write
n, m = map(int, ip().split())
sy, sx, ey, ex = map(int, ip().split())
sy, sx, ey, ex = sy - 1, sx - 1, ey - 1, ex - 1
a, vis, q = [], [[0]*m for _ in range(n)], deque()
vis[sy][sx] = 1
q.append((sy, sx))
for _ in range(n):
    a.append(list(ip()))
cnt = 0
while True:
    tempq = deque()
    while q:
        y, x = q.popleft()
        for d in range(4):
            ny, nx = y + dy[d], x + dx[d]
            if ny < 0 or nx < 0 or ny >= n or nx >= m:
                continue
            if vis[ny][nx]: continue
            if a[ny][nx] == '1':
                tempq.append((ny,nx))
                vis[ny][nx] = vis[y][x] + 1
            else:
                q.append((ny, nx))
                vis[ny][nx] = vis[y][x] + 1
    cnt += 1
    if not tempq or vis[ey][ex]: break
    q = deque(tempq)
print(cnt)