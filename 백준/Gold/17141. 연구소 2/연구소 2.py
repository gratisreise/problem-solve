import sys 
from itertools import combinations
from collections import deque
def check(v, e, vis):
    for i, j in v:
        if vis[i][j] == 0: return False
    for i, j in e:
        if vis[i][j] == 0: return False
    return True
input = sys.stdin.readline
dx, dy = [-1, 0, 1, 0], [0, 1, 0, -1]
n, m = map(int, input().split())
grid = []
vir, empty = [], []
for i in range(n):
    grid.append(list(map(int, input().split())))
    for j in range(n):
        if grid[i][j] == 2:
            vir.append((i, j))
        elif grid[i][j] == 0:
            empty.append((i, j))
combis = combinations(vir, m)
ret = int(1e9)
for combi in combis:
    vis = [[0]*n for _ in range(n)]
    q = deque()
    for i, j in combi:
        vis[i][j] = 1
        q.append((i, j))
    time = 0
    # for arr in vis:
    #     print(arr)
    while q:
        x, y = q.popleft()
        time = vis[x][y]-1
        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]
            if not(0 <= nx < n and 0 <= ny < n): continue
            if grid[nx][ny] == 1 or vis[nx][ny]: continue
            vis[nx][ny] = vis[x][y] + 1
            q.append((nx, ny))
    if check(vir, empty, vis):
        ret = min(ret, time)
print(-1 if ret == int(1e9) else ret)