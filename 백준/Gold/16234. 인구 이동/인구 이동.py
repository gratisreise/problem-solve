import sys
from collections import deque
ip, op = sys.stdin.readline, sys.stdout.write
dy, dx = [0, 1, 0, -1], [-1, 0, 1, 0]
def dfs(i, j, vis):
    ans = []
    vis[i][j] = 1
    q = deque()
    q.append((i,j))
    while q:
        y, x = q.pop()
        ans.append((y, x))
        for d in range(4):
            ny, nx = y + dy[d], x + dx[d]
            if ny < 0 or nx < 0 or ny >= n or nx >= n or vis[ny][nx]:
                continue
            if l <= abs(a[ny][nx] - a[y][x]) <= r:
                vis[ny][nx] = 1
                q.append((ny, nx))
    return ans

a = []
n, l, r = map(int, ip().split())
for _ in range(n):
    a.append(list(map(int, ip().split())))

move_count = 0

while True:
    flag = False #이동확인
    vis = [[0]*n for _ in range(n)]
    
    for i in range(n):
        for j in range(n):
            if vis[i][j]: continue #하루에 한번만 이동가능
            temp = dfs(i, j, vis)
            if len(temp) == 1: continue
            sum_p = sum(a[y][x] for y,x in temp)
            for y,x in temp:
                a[y][x] = sum_p // len(temp)
            flag = True     
    if not flag: break
    move_count += 1
print(move_count)