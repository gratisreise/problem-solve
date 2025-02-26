from collections import deque
n, m = map(int, input().split())
a, vis = [], []
dy, dx = [0, 1, 0, -1], [-1, 0, 1, 0]
def dfs(i, j):
    stk = deque()
    vis[i][j] = 1
    stk.append((i,j))
    lis = []
    while stk:
        y,x  =stk.pop()
        for d in range(4):
            ny, nx = y + dy[d], x + dx[d]
            if ny < 0 or ny < 0 or ny >= n or nx >=m:
                continue
            if vis[ny][nx]:
                continue
            if a[ny][nx] == 1: # 멈춤
                lis.append((ny, nx))
            else:#지속
                stk.append((ny, nx))
            vis[ny][nx] = 1
    return lis


for _ in range(n):
    a.append(list(map(int, input().split())))
ret = []
while True:
    vis = [[0]*m for _ in range(n)]
    temp  = dfs(0, 0)
    if not temp: break
    ret.append(len(temp))
    for i,j in temp:
        a[i][j] = 0
print(len(ret))
print(ret[-1])