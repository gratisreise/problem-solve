from collections import deque
dy, dx = [-1, 0, 1, 0], [0, 1, 0, -1]
def dfs(i, j, vis):
    vis[i][j] = 1
    stk = deque()
    stk.append((i,j))
    while stk:
        y, x = stk.pop()
        for d in range(4):
            ny, nx = y + dy[d], x + dx[d]
            if ny < 0 or nx < 0 or ny >= n or nx >= m:
                continue
            if a[ny][nx] == 0 or vis[ny][nx] != 0:
                continue
            vis[ny][nx] = 1
            stk.append((ny, nx))
def melt(i, j):
    cnt = 0
    for d in range(4):
        ny, nx = i + dy[d], j + dx[d]
        if ny < 0 or nx < 0 or ny >= n or nx >= m:
            continue
        if a[ny][nx] == 0: cnt += 1
    return cnt

n, m = map(int, input().split())
time, a, ice = 0, [],[]
for i in range(n):
    a.append(list(map(int, input().split())))
    for j in range(m):
        if a[i][j] != 0: ice.append((i,j))
INF = int(1e9)
ret = INF

while ice:
    vis = [[0]*m for _ in range(n)]
    cnt = 0
    for i,j in ice: # 연결확인
        if vis[i][j] == 0:
            dfs(i, j, vis)
            cnt += 1
    if cnt > 1: 
        ret = min(ret, time)
        break
    ice_melt = []
    for i,j in ice: ice_melt.append(melt(i,j))
    for idx,(i,j) in enumerate(ice):
        a[i][j] = max(0, a[i][j] - ice_melt[idx])
    ice = [x for x in ice if a[x[0]][x[1]] != 0]
    time += 1
print(ret if ret != INF else 0)