from collections import deque

def bfs(sy, sx, ey, ex, maps):
    dy = [-1, 0, 1, 0]
    dx = [0, 1, 0, -1]
    n = len(maps)
    m = len(maps[0])
    q = deque()
    vis = [[0]*m for _ in range(n)]
    
    q.append((1000 * sy + sx))
    vis[sy][sx] = 1
    
    while q:
        last = q.popleft()
        y, x = last//1000, last%1000
        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]
            if ny < 0 or nx < 0 or ny >= n or nx >= m: continue
            if maps[ny][nx] == "X" or vis[ny][nx]: continue
            q.append(ny * 1000 + nx)
            vis[ny][nx] = vis[y][x] + 1
        if vis[ey][ex]: break
    if vis[ey][ex] == 0: return -1
    return vis[ey][ex] - 1    

def solution(maps):
    sy, sx = 0, 0
    ey, ex = 0, 0
    ry, rx = 0, 0
    ret = 0
    for i in range(len(maps)):
        for j in range(len(maps[i])):
            if maps[i][j] == "S":
                sy, sx = i, j
            elif maps[i][j] == "E":
                ey, ex = i, j
            elif maps[i][j] == "L":
                ry, rx = i, j
    dis1 = bfs(sy, sx, ry, rx, maps)
    dis2 = bfs(ry, rx, ey, ex, maps)
    if dis1 == -1 or dis2 == -1: return -1
    return dis1 + dis2
    
# 통로, 벽 
# 한 칸 지나가는데 1초
# 시작점 포함
# 미로탈출 최소시간 구하기
# b
"""
1. 레버로 가서 레버를 내린다
    1-1. 레버로 갈 수 없는 경우 -1
    1-2. 레버로 갈 수 있는 경우 최소경로
2. 출구로 가서 탈출한다
    2-1. 출구로 갈 수 없는 경우 -1
    2-2. 출구로 갌 수 있는 경우 최소경로
"""