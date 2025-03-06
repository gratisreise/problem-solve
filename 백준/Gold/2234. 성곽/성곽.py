import sys

input = sys.stdin.readline

dy, dx = [0, -1, 0, 1], [-1, 0, 1, 0]

def dfs(y, x, cnt):
    if visited[y][x]: return 0
    visited[y][x] = cnt
    size = 1
    for i in range(4):
        if not (grid[y][x] & (1 << i)):
            ny, nx = y + dy[i], x + dx[i]
            if 0 <= ny < m and 0 <= nx < n:
                size += dfs(ny, nx, cnt)
    return size

n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(m)]
visited = [[0]*n for _ in range(m)]
comp_size = [0]*(m*n+1)

cnt = 0
mx = 0
for i in range(m):
    for j in range(n):
        if not visited[i][j]:
            cnt += 1
            comp_size[cnt] = dfs(i, j, cnt)
            mx = max(mx, comp_size[cnt])

big = 0
for i in range(m):
    for j in range(n):
        # 남쪽 체크
        if i + 1 < m:
            a, b = visited[i + 1][j], visited[i][j]
            if a != b:
                big = max(big, comp_size[a] + comp_size[b])

        #동쪽 체크
        if j + 1 < n:
            a, b = visited[i][j + 1], visited[i][j]
            if a != b:
                big = max(big, comp_size[a] + comp_size[b])
print(cnt, mx, big, sep = '\n')