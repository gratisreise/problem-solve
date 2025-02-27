import sys
from collections import deque
ip, op = sys.stdin, sys.stdout
dy, dx, dz = [-1, 0, 1, 0, 0, 0], [0, 1, 0, -1, 0 ,0],[0, 0, 0, 0, -1, 1]
while True:
    s = ip.readline().rstrip()
    if s == '': continue
    l, r, c = map(int, s.split())
    if l == r == c == 0: break
    a,vis = [], [[[0]*c for _ in range(r)] for _ in range(l)]
    idx = 0
    arr = []
    while idx < l:
        temp = ip.readline().rstrip()
        if temp == '': 
            a.append(arr)
            idx += 1
            arr = []
            continue
        arr.append(list(temp))
    for i in range(l):
        for j in range(r):
            for k in range(c):
                if a[i][j][k] == 'S':
                    start = (i, j, k)
                elif a[i][j][k] == 'E':
                    end = (i, j, k)
    vis[start[0]][start[1]][start[2]] = 1
    q = deque()
    q.append(start)
    while q:
        if vis[end[0]][end[1]][end[2]]: break
        z, y, x = q.popleft()
        for d in range(6):
            nz, ny, nx = z + dz[d], y + dy[d], x + dx[d]
            if ny < 0 or nx < 0 or nz < 0: continue
            if ny >= r or nx >= c or nz >= l: continue
            if a[nz][ny][nx] == '#' or vis[nz][ny][nx]: continue
            vis[nz][ny][nx] = vis[z][y][x] + 1
            q.append((nz, ny, nx))
            
    print(f"Escaped in {vis[end[0]][end[1]][end[2]]-1} minute(s)." if vis[end[0]][end[1]][end[2]] else "Trapped!")