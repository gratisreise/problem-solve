from collections import deque
dy, dx = [0, 1, 0, -1], [-1, 0, 1, 0]

def dfs(i, j):
    vis[i][j] =  1
    stk = deque()
    stk.append((i, j))
    cnt = 0
    while stk:
        cnt += 1
        y, x = stk.pop()
        for d in range(4):
            ny, nx = y + dy[d], x + dx[d]
            if ny < 0 or nx < 0 or ny >= n or nx >= m:
                continue
            if a[ny][nx] == 0 or vis[ny][nx] == 1:
                continue
            vis[ny][nx] = 1
            stk.append((ny, nx))
    return cnt

n, m = map(int, input().split())
a, vis = [], [[0]*m for _ in range(n)]
for _ in range(n):
    a.append(list(map(int, input().split())))
ret1, ret2 = 0, 0
for i in range(n):
    for j in range(m):
        if a[i][j] == 1 and vis[i][j] == 0:
            ret1 += 1
            ret2 = max(ret2, dfs(i, j))

print(ret1, ret2, sep = '\n')