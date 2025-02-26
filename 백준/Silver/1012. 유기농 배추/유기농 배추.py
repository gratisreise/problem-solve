from collections import deque
t = int(input())

dy, dx = [0, 1, 0, -1], [-1, 0, 1, 0]
def dfs(y, x, vis, a):
    stk = deque()
    vis[y][x] = 1
    stk.append((y, x))
    while stk:
        cy, cx = stk.pop()
        for d in range(4):
            ny, nx = cy + dy[d], cx + dx[d]
            if ny < 0 or nx < 0 or ny >= n or nx >= m:
                continue
            if a[ny][nx] == 0 | vis[ny][nx]: continue
            vis[ny][nx] = 1
            stk.append((ny, nx))
ret = []
for _ in range(t):
    m, n, k = map(int, input().split())
    a = [[0]*m for _ in range(n)]
    vis = [[0]*m for _ in range(n)]
    for _ in range(k):
        x, y = map(int, input().split())
        a[y][x] = 1
    cnt = 0
    for i in range(n):
        for j in range(m):
            if a[i][j] and vis[i][j] == 0:
                dfs(i, j, vis, a)
                cnt += 1
    ret.append(str(cnt))
print('\n'.join(ret))